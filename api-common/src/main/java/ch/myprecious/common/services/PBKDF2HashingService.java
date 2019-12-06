package ch.myprecious.common.services;

import ch.myprecious.common.exceptions.MyPreciousException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.KeySpec;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class PBKDF2HashingService implements HashingService {

  private static final Logger log = LoggerFactory.getLogger(PBKDF2HashingService.class);

  private final int HASH_ITERATIONS = 65536;
  private final int HASH_LENGTH = 512;
  private final String HASH_ALGORITHM = "PBKDF2WithHmacSHA1";

  public byte[] getSalt() {
    SecureRandom random = new SecureRandom();
    byte[] salt = new byte[16];
    random.nextBytes(salt);
    return salt;
  }

  public byte[] getHashedPassword(String clearTextPassword, byte[] salt) {
    KeySpec spec = new PBEKeySpec(clearTextPassword.toCharArray(), salt, HASH_ITERATIONS,
        HASH_LENGTH);
    try {
      SecretKeyFactory factory = SecretKeyFactory.getInstance(HASH_ALGORITHM);
      return factory.generateSecret(spec).getEncoded();
    } catch (NoSuchAlgorithmException | InvalidKeySpecException nsae) {
      throw new MyPreciousException("Internal Error");
    }

  }
}
