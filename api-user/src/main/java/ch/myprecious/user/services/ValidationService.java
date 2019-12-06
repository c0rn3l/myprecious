package ch.myprecious.user.services;

import ch.myprecious.user.model.rest.CreateUserRequest;

public interface ValidationService {

  void validateUser(CreateUserRequest createUserRequest);
}
