package ch.myprecious.password.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class AESEncryptionService implements EncryptionService {

  private static final Logger log = LoggerFactory.getLogger(AESEncryptionService.class);

  @Override
  public byte[] encrypt(String masterPassword, String childPassword) {
    return childPassword.getBytes();
  }

  @Override
  public String decrypt(String masterPassword, byte[] encryptedChildPassword) {
    return new String(encryptedChildPassword);
  }
}
