package ch.myprecious.user.services;

import ch.myprecious.common.exceptions.DBOperationException;
import ch.myprecious.common.services.HashingService;
import ch.myprecious.user.dao.UserDAO;
import ch.myprecious.user.model.internal.User;
import ch.myprecious.user.model.rest.CreateUserRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SecuredStoreUserService implements StoreUserService {

  private static final Logger log = LoggerFactory.getLogger(SecuredStoreUserService.class);

  @Autowired
  private UserMapper userMapper;

  @Autowired
  private HashingService hashingService;

  @Autowired
  private UserDAO userDAO;

  @Override
  public void storeUser(CreateUserRequest createUserRequest) {
    User user = userMapper.mapToUser(createUserRequest);
    log.debug("Created user object: {}", user);
    user.setSalt(hashingService.getSalt());
    user.setHashedPassword(hashingService.getHashedPassword(user.getPassword(), user.getSalt()));
    log.debug("Created user2 object: {}", user);
    try {
      userDAO.saveUser(user);
    } catch (Exception ex) {
      log.error("SQL operation failed for {}", user.toString(), ex.getCause());
      throw new DBOperationException();
    }
  }


}
