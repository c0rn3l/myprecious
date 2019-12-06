package ch.myprecious.password.model.rest;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import javax.validation.Valid;
import org.springframework.validation.annotation.Validated;

/**
 * Container with all information regarding returning existing passwords.
 */
@ApiModel(description = "Container with all information regarding returning existing passwords.")
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2019-12-05T22:57:47.112Z")

public class GetPasswordsResponse {

  @JsonProperty("childPasswords")
  @Valid
  private List<Password> childPasswords = null;

  public GetPasswordsResponse childPasswords(List<Password> childPasswords) {
    this.childPasswords = childPasswords;
    return this;
  }

  public GetPasswordsResponse addChildPasswordsItem(Password childPasswordsItem) {
    if (this.childPasswords == null) {
      this.childPasswords = new ArrayList<Password>();
    }
    this.childPasswords.add(childPasswordsItem);
    return this;
  }

  /**
   * Get childPasswords
   *
   * @return childPasswords
   **/
  @ApiModelProperty(value = "")

  @Valid

  public List<Password> getChildPasswords() {
    return childPasswords;
  }

  public void setChildPasswords(List<Password> childPasswords) {
    this.childPasswords = childPasswords;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    GetPasswordsResponse getPasswordsResponse = (GetPasswordsResponse) o;
    return Objects.equals(this.childPasswords, getPasswordsResponse.childPasswords);
  }

  @Override
  public int hashCode() {
    return Objects.hash(childPasswords);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class GetPasswordsResponse {\n");

    sb.append("    childPasswords: ").append(toIndentedString(childPasswords)).append("\n");
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

