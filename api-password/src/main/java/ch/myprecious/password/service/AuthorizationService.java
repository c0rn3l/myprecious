package ch.myprecious.password.service;

public interface AuthorizationService {

  void validateIdentity(String username, String password);
}
