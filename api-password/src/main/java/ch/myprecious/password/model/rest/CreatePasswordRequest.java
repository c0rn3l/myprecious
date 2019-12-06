package ch.myprecious.password.model.rest;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.Objects;
import javax.validation.Valid;
import org.springframework.validation.annotation.Validated;

/**
 * Container with all required information to create a new password.
 */
@ApiModel(description = "Container with all required information to create a new password.")
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2019-12-05T22:57:47.112Z")

public class CreatePasswordRequest extends PasswordRequest {

  @JsonProperty("childPassword")
  private Password childPassword = null;

  public CreatePasswordRequest childPassword(Password childPassword) {
    this.childPassword = childPassword;
    return this;
  }

  /**
   * Get childPassword
   *
   * @return childPassword
   **/
  @ApiModelProperty(value = "")

  @Valid

  public Password getChildPassword() {
    return childPassword;
  }

  public void setChildPassword(Password childPassword) {
    this.childPassword = childPassword;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    CreatePasswordRequest createPasswordRequest = (CreatePasswordRequest) o;
    return Objects.equals(this.childPassword, createPasswordRequest.childPassword) &&
        super.equals(o);
  }

  @Override
  public int hashCode() {
    return Objects.hash(childPassword, super.hashCode());
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class CreatePasswordRequest {\n");
    sb.append("    ").append(toIndentedString(super.toString())).append("\n");
    sb.append("    childPassword: ").append(toIndentedString(childPassword)).append("\n");
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

