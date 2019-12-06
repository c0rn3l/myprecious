package ch.myprecious.password.model.rest;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.Objects;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import org.springframework.validation.annotation.Validated;

/**
 * Container with relevant information to identify master user.
 */
@ApiModel(description = "Container with relevant information to identify master user.")
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2019-12-05T22:57:47.112Z")

public class PasswordRequest {

  @JsonProperty("masterUsername")
  private String masterUsername = null;

  @JsonProperty("masterPassword")
  private String masterPassword = null;

  public PasswordRequest masterUsername(String masterUsername) {
    this.masterUsername = masterUsername;
    return this;
  }

  /**
   * Master username.
   *
   * @return masterUsername
   **/
  @ApiModelProperty(required = true, value = "Master username.")
  @NotNull

  @Size(min = 8, max = 30)
  public String getMasterUsername() {
    return masterUsername;
  }

  public void setMasterUsername(String masterUsername) {
    this.masterUsername = masterUsername;
  }

  public PasswordRequest masterPassword(String masterPassword) {
    this.masterPassword = masterPassword;
    return this;
  }

  /**
   * Master password.
   *
   * @return masterPassword
   **/
  @ApiModelProperty(required = true, value = "Master password.")
  @NotNull

  @Size(min = 8, max = 30)
  public String getMasterPassword() {
    return masterPassword;
  }

  public void setMasterPassword(String masterPassword) {
    this.masterPassword = masterPassword;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    PasswordRequest passwordRequest = (PasswordRequest) o;
    return Objects.equals(this.masterUsername, passwordRequest.masterUsername) &&
        Objects.equals(this.masterPassword, passwordRequest.masterPassword);
  }

  @Override
  public int hashCode() {
    return Objects.hash(masterUsername, masterPassword);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class PasswordRequest {\n");

    sb.append("    masterUsername: ").append(toIndentedString(masterUsername)).append("\n");
    sb.append("    masterPassword: ").append(toIndentedString(masterPassword)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces (except the first
   * line).
   */
  private String toIndentedString(java.lang.Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}

