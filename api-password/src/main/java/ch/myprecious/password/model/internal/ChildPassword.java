package ch.myprecious.password.model.internal;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.Objects;

public class ChildPassword {

  private Integer id;
  private String username;
  private String password;
  private byte[] encryptedPassword;
  private String name;
  private String loginUrl;
  private String description;
  private LocalDateTime lastUpdated;

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public byte[] getEncryptedPassword() {
    return encryptedPassword;
  }

  public void setEncryptedPassword(byte[] encryptedPassword) {
    this.encryptedPassword = encryptedPassword;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getLoginUrl() {
    return loginUrl;
  }

  public void setLoginUrl(String loginUrl) {
    this.loginUrl = loginUrl;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public LocalDateTime getLastUpdated() {
    return lastUpdated;
  }

  public void setLastUpdated(LocalDateTime lastUpdated) {
    this.lastUpdated = lastUpdated;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ChildPassword that = (ChildPassword) o;
    return Objects.equals(id, that.id) &&
        Objects.equals(username, that.username) &&
        Objects.equals(password, that.password) &&
        Arrays.equals(encryptedPassword, that.encryptedPassword) &&
        Objects.equals(name, that.name) &&
        Objects.equals(loginUrl, that.loginUrl) &&
        Objects.equals(description, that.description) &&
        Objects.equals(lastUpdated, that.lastUpdated);
  }

  @Override
  public int hashCode() {
    int result = Objects.hash(id, username, password, name, loginUrl, description, lastUpdated);
    result = 31 * result + Arrays.hashCode(encryptedPassword);
    return result;
  }

  @Override
  public String toString() {
    return "ChildPassword{" +
        "id=" + id +
        ", username='" + username + '\'' +
        ", password='" + password + '\'' +
        ", encryptedPassword=" + Arrays.toString(encryptedPassword) +
        ", name='" + name + '\'' +
        ", loginUrl='" + loginUrl + '\'' +
        ", description='" + description + '\'' +
        ", lastUpdated=" + lastUpdated +
        '}';
  }
}
