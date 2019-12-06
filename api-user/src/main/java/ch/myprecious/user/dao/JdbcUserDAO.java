package ch.myprecious.user.dao;

import ch.myprecious.user.model.internal.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class JdbcUserDAO implements UserDAO {

  private final String INSERT_USER_QUERY =
      "INSERT INTO user (master_username, name, email, date_of_birth, salt, master_password)"
          + "VALUES (?,?,?,?,?,?)";

  @Autowired
  private JdbcTemplate jdbcTemplate;

  @Override
  public void saveUser(User user) {
    jdbcTemplate.update(INSERT_USER_QUERY,
        user.getUsername(),
        user.getName(),
        user.getEmail(),
        user.getBirthDay(),
        user.getSalt(),
        user.getHashedPassword());
  }
}
