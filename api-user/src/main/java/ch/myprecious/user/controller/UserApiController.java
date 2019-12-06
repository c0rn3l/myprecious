package ch.myprecious.user.controller;

import ch.myprecious.user.model.rest.CreateUserRequest;
import ch.myprecious.user.services.StoreUserService;
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

@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2019-12-05T22:20:17.511Z")

@Controller
public class UserApiController implements UserApi {

    private static final Logger log = LoggerFactory.getLogger(UserApiController.class);

    @Autowired
    private ObjectMapper objectMapper;
    @Autowired
    private HttpServletRequest request;

    @Autowired
    private StoreUserService storeUserService;

    public ResponseEntity<Void> createUser(@ApiParam(value = "", required = true)
    @Valid @RequestBody CreateUserRequest createUserRequest) {
        log.debug("START - createUser: {}", createUserRequest);
        storeUserService.storeUser(createUserRequest);
        return new ResponseEntity<Void>(HttpStatus.CREATED);
    }

}
