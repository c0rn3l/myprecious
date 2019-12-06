package ch.myprecious.password.service;

import ch.myprecious.common.exceptions.AuthorizationException;
import ch.myprecious.common.services.HashingService;
import ch.myprecious.password.dao.PasswordDAO;
import ch.myprecious.password.model.internal.Credentials;
import java.util.Arrays;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Component;

@Component
public class UserAuthorizationService implements AuthorizationService {

  private static final Logger log = LoggerFactory.getLogger(UserAuthorizationService.class);

  @Autowired
  private HashingService hashingService;
  @Autowired
  private PasswordDAO passwordDAO;

  @Override
  public void validateIdentity(String username, String password) {
    Credentials credentials = null;
    try {
      credentials = passwordDAO.getUserCredentials(username);
      log.debug("Credentials found for username={} are: {}", username, credentials);
    } catch (EmptyResultDataAccessException ex) {
      log.debug("No credentials found for username={}", username);
      throw new AuthorizationException();
    }

    byte[] hashedPassword = hashingService.getHashedPassword(password, credentials.getSalt());
    if (!Arrays.equals(hashedPassword, credentials.getPassword())) {
      throw new AuthorizationException();
    }
  }
}
