package ch.myprecious.password.service;

import ch.myprecious.password.model.internal.ChildPassword;
import ch.myprecious.password.model.rest.CreatePasswordRequest;
import ch.myprecious.password.model.rest.Password;
import ch.myprecious.password.model.rest.UpdatePasswordRequest;

public interface PasswordMapper {

  ChildPassword mapToChildPassword(CreatePasswordRequest createPasswordRequest);

  ChildPassword mapToChildPassword(UpdatePasswordRequest updatePasswordRequest);

  Password mapToPassword(ChildPassword childPassword);

}
