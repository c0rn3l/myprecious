package ch.myprecious.password.service;

import ch.myprecious.password.dao.PasswordDAO;
import ch.myprecious.password.model.internal.ChildPassword;
import ch.myprecious.password.model.rest.CreatePasswordRequest;
import ch.myprecious.password.model.rest.DeletePasswordRequest;
import ch.myprecious.password.model.rest.GetPasswordRequest;
import ch.myprecious.password.model.rest.GetPasswordsRequest;
import ch.myprecious.password.model.rest.Password;
import ch.myprecious.password.model.rest.UpdatePasswordRequest;
import java.util.List;
import java.util.stream.Collectors;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SecuredStorePasswordService implements StorePasswordService {

  private static final Logger log = LoggerFactory.getLogger(SecuredStorePasswordService.class);

  @Autowired
  private PasswordMapper passwordMapper;

  @Autowired
  private EncryptionService encryptionService;

  @Autowired
  private PasswordDAO passwordDAO;

  @Override
  public void storePassword(CreatePasswordRequest createPasswordRequest) {
    ChildPassword childPassword = passwordMapper.mapToChildPassword(createPasswordRequest);
    childPassword.setEncryptedPassword(
        encryptionService
            .encrypt(createPasswordRequest.getMasterPassword(), childPassword.getPassword())
    );
    passwordDAO.savePassword(createPasswordRequest.getMasterUsername(), childPassword);
  }

  @Override
  public void updatePassword(UpdatePasswordRequest updatePasswordRequest) {
    ChildPassword childPassword = passwordMapper.mapToChildPassword(updatePasswordRequest);
    childPassword.setEncryptedPassword(
        encryptionService
            .encrypt(updatePasswordRequest.getMasterPassword(), childPassword.getPassword())
    );
    passwordDAO.updatePassword(updatePasswordRequest.getMasterUsername(), childPassword);
  }

  @Override
  public void deletePassword(DeletePasswordRequest deletePasswordRequest) {
    passwordDAO.deletePassword(deletePasswordRequest.getMasterUsername(),
        deletePasswordRequest.getChildUsername());
  }

  @Override
  public Password getPassword(GetPasswordRequest getPasswordRequest) {
    ChildPassword childPassword = passwordDAO.getPassword(getPasswordRequest.getMasterUsername(),
        getPasswordRequest.getChildUsername());
    childPassword.setPassword(
        encryptionService.decrypt(getPasswordRequest.getMasterPassword(),
            childPassword.getEncryptedPassword()));
    return passwordMapper.mapToPassword(childPassword);
  }

  @Override
  public List<Password> getPasswords(GetPasswordsRequest getPasswordsRequest) {
    List<ChildPassword> childPasswords = passwordDAO
        .getPasswords(getPasswordsRequest.getMasterUsername());
    childPasswords.forEach(childPassword -> {
      childPassword.setPassword(
          encryptionService.decrypt(getPasswordsRequest.getMasterPassword(),
              childPassword.getEncryptedPassword()));
    });
    return childPasswords.stream().map(passwordMapper::mapToPassword).collect(Collectors.toList());
  }
}
