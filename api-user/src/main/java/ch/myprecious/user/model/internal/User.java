package ch.myprecious.user.model.internal;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Objects;

public class User {

  private String username;
  private String password;
  private byte[] hashedPassword;
  private byte[] salt;
  private String email;
  private String name;
  private LocalDate birthDay;

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

  public byte[] getHashedPassword() {
    return hashedPassword;
  }

  public void setHashedPassword(byte[] hashedPassword) {
    this.hashedPassword = hashedPassword;
  }

  public byte[] getSalt() {
    return salt;
  }

  public void setSalt(byte[] salt) {
    this.salt = salt;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public LocalDate getBirthDay() {
    return birthDay;
  }

  public void setBirthDay(LocalDate birthDay) {
    this.birthDay = birthDay;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    User user = (User) o;
    return Objects.equals(username, user.username) &&
        Objects.equals(password, user.password) &&
        Arrays.equals(salt, user.salt) &&
        Objects.equals(email, user.email) &&
        Objects.equals(name, user.name) &&
        Objects.equals(birthDay, user.birthDay);
  }

  @Override
  public int hashCode() {
    int result = Objects.hash(username, password, email, name, birthDay);
    result = 31 * result + Arrays.hashCode(salt);
    return result;
  }

  @Override
  public String toString() {
    return "User{" +
        "username='" + username + '\'' +
        ", password='" + password + '\'' +
        ", hashedPassword=" + Arrays.toString(hashedPassword) +
        ", salt=" + Arrays.toString(salt) +
        ", email='" + email + '\'' +
        ", name='" + name + '\'' +
        ", birthDay=" + birthDay +
        '}';
  }
}
