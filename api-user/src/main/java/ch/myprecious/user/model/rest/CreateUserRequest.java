package ch.myprecious.user.model.rest;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.Objects;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import org.springframework.validation.annotation.Validated;

/**
 * Container with all required information to create a new user.
 */
@ApiModel(description = "Container with all required information to create a new user.")
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2019-12-05T22:20:17.511Z")

public class CreateUserRequest {

  @JsonProperty("username")
  private String username = null;

  @JsonProperty("password")
  private String password = null;

  @JsonProperty("name")
  private String name = null;

  @JsonProperty("email")
  private String email = null;

  @JsonProperty("birthDate")
  private String birthDate = null;

  public CreateUserRequest username(String username) {
    this.username = username;
    return this;
  }

  /**
   * Master username. Unique.
   *
   * @return username
   **/
  @ApiModelProperty(required = true, value = "Master username. Unique.")
  @NotNull

  @Size(min = 8, max = 30)
  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public CreateUserRequest password(String password) {
    this.password = password;
    return this;
  }

  /**
   * Master password.
   *
   * @return password
   **/
  @ApiModelProperty(required = true, value = "Master password.")
  @NotNull

  @Size(min = 8, max = 30)
  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public CreateUserRequest name(String name) {
    this.name = name;
    return this;
  }

  /**
   * User's name.
   *
   * @return name
   **/
  @ApiModelProperty(required = true, value = "User's name.")
  @NotNull

  @Size(min = 2, max = 30)
  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public CreateUserRequest email(String email) {
    this.email = email;
    return this;
  }

  /**
   * User's email.
   *
   * @return email
   **/
  @ApiModelProperty(required = true, value = "User's email.")
  @NotNull

  @Pattern(regexp = "^[A-Za-z0-9_\\.-]{2,27}@[A-Za-z0-9_\\.-]{2,20}\\.[A-Za-z]{2,3}$")
  @Size(min = 6, max = 50)
  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public CreateUserRequest birthDate(String birthDate) {
    this.birthDate = birthDate;
    return this;
  }

  /**
   * User's birth date. Format is yyyy-MM-dd.
   *
   * @return birthDate
   **/
  @ApiModelProperty(required = true, value = "User's birth date. Format is yyyy-MM-dd.")
  @NotNull

  @Pattern(regexp = "^(19\\d{2})|(20[0-2]\\d)-((0[1-9])|10|11|12)-(0[1-9]|((1|2)\\d)|30|31)$")
  public String getBirthDate() {
    return birthDate;
  }

  public void setBirthDate(String birthDate) {
    this.birthDate = birthDate;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    CreateUserRequest createUserRequest = (CreateUserRequest) o;
    return Objects.equals(this.username, createUserRequest.username) &&
        Objects.equals(this.password, createUserRequest.password) &&
        Objects.equals(this.name, createUserRequest.name) &&
        Objects.equals(this.email, createUserRequest.email) &&
        Objects.equals(this.birthDate, createUserRequest.birthDate);
  }

  @Override
  public int hashCode() {
    return Objects.hash(username, password, name, email, birthDate);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class CreateUserRequest {\n");

    sb.append("    username: ").append(toIndentedString(username)).append("\n");
    sb.append("    password: ").append(toIndentedString(password)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    email: ").append(toIndentedString(email)).append("\n");
    sb.append("    birthDate: ").append(toIndentedString(birthDate)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces (except the first
   * line).
   */
  private String toIndentedString(Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}

