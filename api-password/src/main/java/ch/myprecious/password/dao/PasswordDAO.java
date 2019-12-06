package ch.myprecious.password.dao;

import ch.myprecious.password.model.internal.ChildPassword;
import ch.myprecious.password.model.internal.Credentials;
import java.util.List;

public interface PasswordDAO {

  Credentials getUserCredentials(String masterUsername);

  void savePassword(String masterUsername, ChildPassword childPassword);

  void updatePassword(String masterUsername, ChildPassword childPassword);

  void deletePassword(String masterUsername, String childUsername);

  ChildPassword getPassword(String masterUsername, String childUsername);

  List<ChildPassword> getPasswords(String masterUsername);
}
