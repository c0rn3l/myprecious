package ch.myprecious.password.model.internal;

import java.util.Arrays;
import java.util.Objects;

public class Credentials {

  private String username;
  private byte[] password;
  private byte[] salt;

  public Credentials(String username, byte[] password, byte[] salt) {
    this.username = username;
    this.password = password;
    this.salt = salt;
  }

  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public byte[] getPassword() {
    return password;
  }

  public void setPassword(byte[] password) {
    this.password = password;
  }

  public byte[] getSalt() {
    return salt;
  }

  public void setSalt(byte[] salt) {
    this.salt = salt;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Credentials that = (Credentials) o;
    return Objects.equals(username, that.username) &&
        Arrays.equals(password, that.password) &&
        Arrays.equals(salt, that.salt);
  }

  @Override
  public int hashCode() {
    int result = Objects.hash(username);
    result = 31 * result + Arrays.hashCode(password);
    result = 31 * result + Arrays.hashCode(salt);
    return result;
  }

  @Override
  public String toString() {
    return "Credentials{" +
        "username='" + username + '\'' +
        ", password=" + Arrays.toString(password) +
        ", salt=" + Arrays.toString(salt) +
        '}';
  }
}
