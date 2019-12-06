package ch.myprecious.password.controller;

import ch.myprecious.password.model.rest.CreatePasswordRequest;
import ch.myprecious.password.model.rest.DeletePasswordRequest;
import ch.myprecious.password.model.rest.GetPasswordRequest;
import ch.myprecious.password.model.rest.GetPasswordResponse;
import ch.myprecious.password.model.rest.GetPasswordsRequest;
import ch.myprecious.password.model.rest.GetPasswordsResponse;
import ch.myprecious.password.model.rest.UpdatePasswordRequest;
import ch.myprecious.password.service.AuthorizationService;
import ch.myprecious.password.service.SecuredStorePasswordService;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.swagger.annotations.ApiParam;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;

@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2019-12-05T22:57:47.112Z")

@Controller
public class PasswordApiController implements PasswordApi {

    private static final Logger log = LoggerFactory.getLogger(PasswordApiController.class);

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private HttpServletRequest request;

    @Autowired
    private AuthorizationService authorizationService;

    @Autowired
    private SecuredStorePasswordService securedStorePasswordService;

    public ResponseEntity<Void> createPassword(
        @ApiParam(value = "", required = true) @Valid @RequestBody CreatePasswordRequest createPasswordRequest) {
        log.debug("START - createUser: {}", createPasswordRequest);
        authorizationService.validateIdentity(
            createPasswordRequest.getMasterUsername(),
            createPasswordRequest.getMasterPassword());

        securedStorePasswordService.storePassword(createPasswordRequest);
        return new ResponseEntity<Void>(HttpStatus.CREATED);
    }

    public ResponseEntity<Void> deletePassword(
        @ApiParam(value = "", required = true) @Valid @RequestBody DeletePasswordRequest deletePasswordRequest) {
        log.debug("START - deletePassword: {}", deletePasswordRequest);
        authorizationService.validateIdentity(
            deletePasswordRequest.getMasterUsername(),
            deletePasswordRequest.getMasterPassword());

        securedStorePasswordService.deletePassword(deletePasswordRequest);
        return new ResponseEntity<Void>(HttpStatus.OK);
    }

    public ResponseEntity<GetPasswordResponse> getPassword(
        @ApiParam(value = "", required = true) @Valid @RequestBody GetPasswordRequest getPasswordRequest) {
        log.debug("START - getPassword: {}", getPasswordRequest);
        authorizationService.validateIdentity(
            getPasswordRequest.getMasterUsername(),
            getPasswordRequest.getMasterPassword());

        GetPasswordResponse getPasswordResponse = new GetPasswordResponse();
        getPasswordResponse
            .setChildPassword(securedStorePasswordService.getPassword(getPasswordRequest));
        return new ResponseEntity<GetPasswordResponse>(getPasswordResponse, HttpStatus.OK);
    }

    public ResponseEntity<GetPasswordsResponse> getPasswords(
        @ApiParam(value = "", required = true) @Valid @RequestBody GetPasswordsRequest getPasswordsRequest) {
        log.debug("START - getPasswords: {}", getPasswordsRequest);
        authorizationService.validateIdentity(
            getPasswordsRequest.getMasterUsername(),
            getPasswordsRequest.getMasterPassword());

        GetPasswordsResponse getPasswordsResponse = new GetPasswordsResponse();
        getPasswordsResponse
            .setChildPasswords(securedStorePasswordService.getPasswords(getPasswordsRequest));
        return new ResponseEntity<GetPasswordsResponse>(getPasswordsResponse, HttpStatus.OK);
    }

    public ResponseEntity<Void> updatePassword(
        @ApiParam(value = "", required = true) @Valid @RequestBody UpdatePasswordRequest updatePasswordRequest) {
        log.debug("START - updatePassword: {}", updatePasswordRequest);
        authorizationService.validateIdentity(
            updatePasswordRequest.getMasterUsername(),
            updatePasswordRequest.getMasterPassword());

        securedStorePasswordService.updatePassword(updatePasswordRequest);
        return new ResponseEntity<Void>(HttpStatus.OK);
    }

}
