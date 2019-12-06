package ch.myprecious.user.services;

import ch.myprecious.user.model.rest.CreateUserRequest;

public interface StoreUserService {

  void storeUser(CreateUserRequest createUserRequest);

}
