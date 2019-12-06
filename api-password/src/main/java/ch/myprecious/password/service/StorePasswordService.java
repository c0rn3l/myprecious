package ch.myprecious.password.service;

import ch.myprecious.password.model.rest.CreatePasswordRequest;
import ch.myprecious.password.model.rest.DeletePasswordRequest;
import ch.myprecious.password.model.rest.GetPasswordRequest;
import ch.myprecious.password.model.rest.GetPasswordsRequest;
import ch.myprecious.password.model.rest.Password;
import ch.myprecious.password.model.rest.UpdatePasswordRequest;
import java.util.List;

public interface StorePasswordService {

  void storePassword(CreatePasswordRequest createPasswordRequest);

  void updatePassword(UpdatePasswordRequest updatePasswordRequest);

  void deletePassword(DeletePasswordRequest deletePasswordRequest);

  Password getPassword(GetPasswordRequest getPasswordRequest);

  List<Password> getPasswords(GetPasswordsRequest getPasswordsRequest);

}
