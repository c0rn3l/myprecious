package ch.myprecious.user.services;

import ch.myprecious.user.model.internal.User;
import ch.myprecious.user.model.rest.CreateUserRequest;

public interface UserMapper {

  User mapToUser(CreateUserRequest createUserRequest);
}
