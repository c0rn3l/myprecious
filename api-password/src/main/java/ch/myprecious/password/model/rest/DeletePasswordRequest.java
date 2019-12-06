package ch.myprecious.password.model.rest;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.Objects;
import javax.validation.constraints.Size;
import org.springframework.validation.annotation.Validated;

/**
 * Container with all required information to delete an existing password.
 */
@ApiModel(description = "Container with all required information to delete an existing password.")
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2019-12-05T22:57:47.112Z")

public class DeletePasswordRequest extends PasswordRequest {

  @JsonProperty("childUsername")
  private String childUsername = null;

  public DeletePasswordRequest childUsername(String childUsername) {
    this.childUsername = childUsername;
    return this;
  }

  /**
   * Child username.
   *
   * @return childUsername
   **/
  @ApiModelProperty(value = "Child username.")

  @Size(min = 8, max = 30)
  public String getChildUsername() {
    return childUsername;
  }

  public void setChildUsername(String childUsername) {
    this.childUsername = childUsername;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    DeletePasswordRequest deletePasswordRequest = (DeletePasswordRequest) o;
    return Objects.equals(this.childUsername, deletePasswordRequest.childUsername) &&
        super.equals(o);
  }

  @Override
  public int hashCode() {
    return Objects.hash(childUsername, super.hashCode());
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class DeletePasswordRequest {\n");
    sb.append("    ").append(toIndentedString(super.toString())).append("\n");
    sb.append("    childUsername: ").append(toIndentedString(childUsername)).append("\n");
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

