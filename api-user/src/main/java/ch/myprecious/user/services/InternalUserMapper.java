package ch.myprecious.user.services;

import ch.myprecious.user.model.internal.User;
import ch.myprecious.user.model.rest.CreateUserRequest;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import org.springframework.stereotype.Component;

@Component
public class InternalUserMapper implements UserMapper {

  private DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

  public User mapToUser(CreateUserRequest createUserRequest) {
    User user = new User();
    user.setUsername(createUserRequest.getUsername());
    user.setPassword(createUserRequest.getPassword());
    user.setEmail(createUserRequest.getEmail());
    user.setName(createUserRequest.getName());
    user.setBirthDay(LocalDate.parse(createUserRequest.getBirthDate(), formatter));
    return user;
  }
}
