package ch.myprecious.password.model.rest;

import io.swagger.annotations.ApiModel;
import java.util.Objects;
import org.springframework.validation.annotation.Validated;

/**
 * Container with all required information to get existing passwords for given user.
 */
@ApiModel(description = "Container with all required information to get existing passwords for given user.")
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2019-12-05T22:57:47.112Z")

public class GetPasswordsRequest extends PasswordRequest {

  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    return true;
  }

  @Override
  public int hashCode() {
    return Objects.hash(super.hashCode());
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class GetPasswordsRequest {\n");
    sb.append("    ").append(toIndentedString(super.toString())).append("\n");
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

