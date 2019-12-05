package ch.myprecious.user;

import ch.myprecious.common.exceptions.MyPreciousException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ApiUser {

  private static final Logger log = LoggerFactory.getLogger(ApiUser.class);

  public static void main(String[] args) {
    try {
      SpringApplication.run(ApiUser.class, args);
    } catch (MyPreciousException we) {
      log.error("Error in main: ", we);
    }

  }
}
