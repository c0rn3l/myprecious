package ch.myprecious.password.dao;

import ch.myprecious.password.model.internal.ChildPassword;
import ch.myprecious.password.model.internal.Credentials;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

@Repository
public class JdbcPasswordDAO implements PasswordDAO {

  private final String SELECT_CREDENTIALS_QUERY =
      "SELECT master_username, master_password, salt FROM user WHERE master_username = ? ";

  private final String INSERT_PASSWORD_QUERY =
      "INSERT INTO password(master_username, child_username, child_password, name, login_url, "
          + "description, creation_date, last_update) VALUES (?,?,?,?,?,?,SYSDATE,SYSDATE)";

  private final String UPDATE_PASSWORD_QUERY = "UPDATE password SET child_username = ? , "
      + "child_password = ? , name = ? , login_url = ? , description = ? , creation_date = SYSDATE, "
      + "last_update = SYSDATE WHERE id = ? AND master_username = ? ";

  private final String DELETE_PASSWORD_QUERY = "DELETE FROM password WHERE child_username = ? "
      + " AND master_username = ? ";

  private final String SELECT_PASSWORDS_QUERY = "SELECT id, master_username, child_username, "
      + "child_password, name, login_url, description, last_update FROM password "
      + "WHERE master_username = ? ";

  private final String SELECT_PASSWORD_QUERY = SELECT_PASSWORDS_QUERY + " AND child_username = ? ";

  @Autowired
  private JdbcTemplate jdbcTemplate;

  @Override
  public Credentials getUserCredentials(String masterUsername) {
    return jdbcTemplate.queryForObject(SELECT_CREDENTIALS_QUERY, new Object[]{masterUsername},
        (rs, rowNum) -> new Credentials(
            rs.getString("master_username"),
            rs.getBytes("master_password"),
            rs.getBytes("salt")
        ));
  }

  @Override
  public void savePassword(String masterUsername, ChildPassword childPassword) {
    jdbcTemplate.update(INSERT_PASSWORD_QUERY,
        masterUsername,
        childPassword.getUsername(),
        childPassword.getEncryptedPassword(),
        childPassword.getName(),
        childPassword.getLoginUrl(),
        childPassword.getDescription());
  }

  @Override
  public void updatePassword(String masterUsername, ChildPassword childPassword) {
    jdbcTemplate.update(UPDATE_PASSWORD_QUERY,
        childPassword.getUsername(),
        childPassword.getPassword(),
        childPassword.getName(),
        childPassword.getLoginUrl(),
        childPassword.getDescription(),
        childPassword.getId(),
        masterUsername);
  }

  @Override
  public void deletePassword(String masterUsername, String childUsername) {
    jdbcTemplate.update(DELETE_PASSWORD_QUERY,
        childUsername,
        masterUsername);
  }

  @Override
  public ChildPassword getPassword(String masterUsername, String childUsername) {
    return jdbcTemplate
        .queryForObject(SELECT_PASSWORD_QUERY, new Object[]{masterUsername, childUsername},
            getChildPasswordRowMapper());
  }

  @Override
  public List<ChildPassword> getPasswords(String masterUsername) {
    return jdbcTemplate.query(SELECT_PASSWORDS_QUERY, getChildPasswordRowMapper(), masterUsername);
  }

  private RowMapper<ChildPassword> getChildPasswordRowMapper() {
    return (rs, rowNum) -> {
      ChildPassword childPassword = new ChildPassword();
      childPassword.setUsername(rs.getString("child_username"));
      childPassword.setEncryptedPassword(rs.getBytes("child_password"));
      childPassword.setName(rs.getString("name"));
      childPassword.setDescription(rs.getString("description"));
      childPassword.setLoginUrl(rs.getString("login_url"));
      childPassword.setLastUpdated(rs.getTimestamp("last_update").toLocalDateTime());
      return childPassword;
    };
  }
}
