package ch.myprecious.password.model.rest;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.Objects;
import javax.validation.constraints.Size;
import org.springframework.validation.annotation.Validated;

/**
 * Payload required to create a new user.
 */
@ApiModel(description = "Payload required to create a new user.")
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2019-12-05T23:56:47.966Z")

public class Password {

  @JsonProperty("id")
  private Integer id = null;

  @JsonProperty("name")
  private String name = null;

  @JsonProperty("username")
  private String username = null;

  @JsonProperty("password")
  private String password = null;

  @JsonProperty("url")
  private String url = null;

  @JsonProperty("description")
  private String description = null;

  @JsonProperty("lastUpdated")
  private String lastUpdated = null;

  public Password id(Integer id) {
    this.id = id;
    return this;
  }

  /**
   * Unique identifier.
   *
   * @return id
   **/
  @ApiModelProperty(value = "Unique identifier.")

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public Password name(String name) {
    this.name = name;
    return this;
  }

  /**
   * Alias for given credentials.
   *
   * @return name
   **/
  @ApiModelProperty(value = "Alias for given credentials.")

  @Size(min = 2, max = 30)
  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Password username(String username) {
    this.username = username;
    return this;
  }

  /**
   * Child username.
   *
   * @return username
   **/
  @ApiModelProperty(value = "Child username.")

  @Size(min = 8, max = 30)
  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public Password password(String password) {
    this.password = password;
    return this;
  }

  /**
   * Child password.
   *
   * @return password
   **/
  @ApiModelProperty(value = "Child password.")

  @Size(min = 8, max = 30)
  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public Password url(String url) {
    this.url = url;
    return this;
  }

  /**
   * Login URL.
   *
   * @return url
   **/
  @ApiModelProperty(value = "Login URL.")

  @Size(min = 4, max = 100)
  public String getUrl() {
    return url;
  }

  public void setUrl(String url) {
    this.url = url;
  }

  public Password description(String description) {
    this.description = description;
    return this;
  }

  /**
   * Describes the context of use.
   *
   * @return description
   **/
  @ApiModelProperty(value = "Describes the context of use.")

  @Size(min = 4, max = 100)
  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public Password lastUpdated(String lastUpdated) {
    this.lastUpdated = lastUpdated;
    return this;
  }

  /**
   * Time when child password was last updated. Format yyyy-MM-dd HH:mm:ss
   *
   * @return lastUpdated
   **/
  @ApiModelProperty(value = "Time when child password was last updated. Format yyyy-MM-dd HH:mm:ss")

  public String getLastUpdated() {
    return lastUpdated;
  }

  public void setLastUpdated(String lastUpdated) {
    this.lastUpdated = lastUpdated;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Password password = (Password) o;
    return Objects.equals(this.id, password.id) &&
        Objects.equals(this.name, password.name) &&
        Objects.equals(this.username, password.username) &&
        Objects.equals(this.password, password.password) &&
        Objects.equals(this.url, password.url) &&
        Objects.equals(this.description, password.description) &&
        Objects.equals(this.lastUpdated, password.lastUpdated);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, name, username, password, url, description, lastUpdated);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Password {\n");

    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    username: ").append(toIndentedString(username)).append("\n");
    sb.append("    password: ").append(toIndentedString(password)).append("\n");
    sb.append("    url: ").append(toIndentedString(url)).append("\n");
    sb.append("    description: ").append(toIndentedString(description)).append("\n");
    sb.append("    lastUpdated: ").append(toIndentedString(lastUpdated)).append("\n");
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

