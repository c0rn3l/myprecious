/**
 * NOTE: This class is auto generated by the swagger code generator program (2.4.10).
 * https://github.com/swagger-api/swagger-codegen Do not edit the class manually.
 */
package ch.myprecious.user.controller;

import ch.myprecious.user.model.rest.CreateUserRequest;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import javax.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2019-12-05T22:20:17.511Z")

@Api(value = "user", description = "the user API")
public interface UserApi {

    @ApiOperation(value = "Creates new user.", nickname = "createUser", notes = "This call demonstrates creation of a new user.", tags = {
        "user",})
    @ApiResponses(value = {
        @ApiResponse(code = 201, message = "User successfully created."),
        @ApiResponse(code = 400, message = "Invalid input."),
        @ApiResponse(code = 500, message = "Internal Server Error.")})
    @RequestMapping(value = "/user",
        produces = {"application/json"},
        consumes = {"application/json"},
        method = RequestMethod.POST)
    ResponseEntity<Void> createUser(
        @ApiParam(value = "", required = true) @Valid @RequestBody CreateUserRequest createUserRequest);

}
