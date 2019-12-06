package ch.myprecious.user.services;

import ch.myprecious.common.exceptions.InputValidationException;
import ch.myprecious.user.model.rest.CreateUserRequest;
import org.springframework.stereotype.Component;

@Component
public class InputValidationService implements ValidationService {

  @Override
  public void validateUser(CreateUserRequest createUserRequest) {
    if (createUserRequest == null) {
      throw new InputValidationException("Request is empty");
    } else if (createUserRequest.getUsername() == null || createUserRequest.getUsername()
        .isEmpty()) {
      throw new InputValidationException("username is empty");
    } else if (createUserRequest.getPassword() == null || createUserRequest.getPassword()
        .isEmpty()) {
      throw new InputValidationException("password is empty");
    } else if (createUserRequest.getEmail() == null || createUserRequest.getEmail().isEmpty()) {
      throw new InputValidationException("email is empty");
    } else if (createUserRequest.getName() == null || createUserRequest.getName().isEmpty()) {
      throw new InputValidationException("name is empty");
    } else if (createUserRequest.getBirthDate() == null || createUserRequest.getBirthDate()
        .isEmpty()) {
      throw new InputValidationException("birthDay is empty");
    }
  }
}
