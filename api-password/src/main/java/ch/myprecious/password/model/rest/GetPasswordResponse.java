package ch.myprecious.password.model.rest;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.Objects;
import javax.validation.Valid;
import org.springframework.validation.annotation.Validated;

/**
 * Container with all information regarding returning existing password.
 */
@ApiModel(description = "Container with all information regarding returning existing password.")
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2019-12-05T22:57:47.112Z")

public class GetPasswordResponse {

  @JsonProperty("childPassword")
  private Password childPassword = null;

  public GetPasswordResponse childPassword(Password childPassword) {
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
    GetPasswordResponse getPasswordResponse = (GetPasswordResponse) o;
    return Objects.equals(this.childPassword, getPasswordResponse.childPassword);
  }

  @Override
  public int hashCode() {
    return Objects.hash(childPassword);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class GetPasswordResponse {\n");

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

