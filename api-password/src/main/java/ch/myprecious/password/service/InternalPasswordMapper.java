package ch.myprecious.password.service;

import ch.myprecious.password.model.internal.ChildPassword;
import ch.myprecious.password.model.rest.CreatePasswordRequest;
import ch.myprecious.password.model.rest.Password;
import ch.myprecious.password.model.rest.UpdatePasswordRequest;
import java.time.format.DateTimeFormatter;
import org.springframework.stereotype.Component;

@Component
public class InternalPasswordMapper implements PasswordMapper {

  private final DateTimeFormatter LAST_UPDATED_FORMAT = DateTimeFormatter
      .ofPattern("yyyy-MM-dd HH:mm:ss");

  @Override
  public ChildPassword mapToChildPassword(CreatePasswordRequest createPasswordRequest) {
    return mapToChildPassword(createPasswordRequest.getChildPassword());
  }

  @Override
  public ChildPassword mapToChildPassword(UpdatePasswordRequest updatePasswordRequest) {
    return mapToChildPassword(updatePasswordRequest.getChildPassword());
  }

  @Override
  public Password mapToPassword(ChildPassword childPassword) {
    Password password = new Password();
    password.setId(childPassword.getId());
    password.setUsername(childPassword.getUsername());
    password.setPassword(childPassword.getPassword());
    password.setName(childPassword.getName());
    password.setDescription(childPassword.getDescription());
    password.setUrl(childPassword.getLoginUrl());
    password.setLastUpdated(childPassword.getLastUpdated().format(LAST_UPDATED_FORMAT));
    return password;
  }

  private ChildPassword mapToChildPassword(Password password) {
    ChildPassword childPassword = new ChildPassword();
    childPassword.setUsername(password.getUsername());
    childPassword.setPassword(password.getPassword());
    childPassword.setName(password.getName());
    childPassword.setDescription(password.getName());
    childPassword.setLoginUrl(password.getUrl());
    return childPassword;
  }
}
