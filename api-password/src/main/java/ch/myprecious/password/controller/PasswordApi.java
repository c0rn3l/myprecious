/**
 * NOTE: This class is auto generated by the swagger code generator program (2.4.10).
 * https://github.com/swagger-api/swagger-codegen Do not edit the class manually.
 */
package ch.myprecious.password.controller;

import ch.myprecious.password.model.rest.CreatePasswordRequest;
import ch.myprecious.password.model.rest.DeletePasswordRequest;
import ch.myprecious.password.model.rest.GetPasswordRequest;
import ch.myprecious.password.model.rest.GetPasswordResponse;
import ch.myprecious.password.model.rest.GetPasswordsRequest;
import ch.myprecious.password.model.rest.GetPasswordsResponse;
import ch.myprecious.password.model.rest.UpdatePasswordRequest;
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

@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2019-12-05T22:57:47.112Z")

@Api(value = "password", description = "the user API")
public interface PasswordApi {

    @ApiOperation(value = "Creates new password.", nickname = "createPassword", notes = "This call demonstrates creation of a new password.", tags = {
        "password",})
    @ApiResponses(value = {
        @ApiResponse(code = 201, message = "Password successfully created."),
        @ApiResponse(code = 400, message = "Invalid input."),
        @ApiResponse(code = 404, message = "User not found."),
        @ApiResponse(code = 500, message = "Internal Server Error.")})
    @RequestMapping(value = "/user/password",
        produces = {"application/json"},
        consumes = {"application/json"},
        method = RequestMethod.POST)
    ResponseEntity<Void> createPassword(
        @ApiParam(value = "", required = true) @Valid @RequestBody CreatePasswordRequest createPasswordRequest);


    @ApiOperation(value = "Deletes a password.", nickname = "deletePassword", notes = "This call demonstrates deletion of an existing password.", tags = {
        "password",})
    @ApiResponses(value = {
        @ApiResponse(code = 201, message = "Password successfully created."),
        @ApiResponse(code = 400, message = "Invalid input."),
        @ApiResponse(code = 404, message = "User not found."),
        @ApiResponse(code = 500, message = "Internal Server Error.")})
    @RequestMapping(value = "/user/password",
        produces = {"application/json"},
        consumes = {"application/json"},
        method = RequestMethod.DELETE)
    ResponseEntity<Void> deletePassword(
        @ApiParam(value = "", required = true) @Valid @RequestBody DeletePasswordRequest createPasswordRequest);


    @ApiOperation(value = "Get a password.", nickname = "getPassword", notes = "This call demonstrates reading of an existing password.", response = GetPasswordResponse.class, tags = {
        "password",})
    @ApiResponses(value = {
        @ApiResponse(code = 200, message = "Password successfully created.", response = GetPasswordResponse.class),
        @ApiResponse(code = 400, message = "Invalid input."),
        @ApiResponse(code = 404, message = "User not found."),
        @ApiResponse(code = 500, message = "Internal Server Error.")})
    @RequestMapping(value = "/user/password",
        produces = {"application/json"},
        consumes = {"application/json"},
        method = RequestMethod.GET)
    ResponseEntity<GetPasswordResponse> getPassword(
        @ApiParam(value = "", required = true) @Valid @RequestBody GetPasswordRequest getPasswordRequest);


    @ApiOperation(value = "Get passwords.", nickname = "getPasswords", notes = "This call demonstrates reading of all existing passwords for given user.", response = GetPasswordsResponse.class, tags = {
        "password",})
    @ApiResponses(value = {
        @ApiResponse(code = 200, message = "Password successfully created.", response = GetPasswordsResponse.class),
        @ApiResponse(code = 400, message = "Invalid input."),
        @ApiResponse(code = 404, message = "User not found."),
        @ApiResponse(code = 500, message = "Internal Server Error.")})
    @RequestMapping(value = "/user/passwords",
        produces = {"application/json"},
        consumes = {"application/json"},
        method = RequestMethod.GET)
    ResponseEntity<GetPasswordsResponse> getPasswords(
        @ApiParam(value = "", required = true) @Valid @RequestBody GetPasswordsRequest getPasswordsRequest);


    @ApiOperation(value = "Update a password.", nickname = "updatePassword", notes = "This call demonstrates update of an existing password.", tags = {
        "password",})
    @ApiResponses(value = {
        @ApiResponse(code = 200, message = "Password successfully updated."),
        @ApiResponse(code = 400, message = "Invalid input."),
        @ApiResponse(code = 404, message = "User not found."),
        @ApiResponse(code = 500, message = "Internal Server Error.")})
    @RequestMapping(value = "/user/password",
        produces = {"application/json"},
        consumes = {"application/json"},
        method = RequestMethod.PUT)
    ResponseEntity<Void> updatePassword(
        @ApiParam(value = "", required = true) @Valid @RequestBody UpdatePasswordRequest updatePasswordRequest);

}
