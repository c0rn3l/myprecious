package ch.myprecious.common.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
public class DBOperationException extends MyPreciousException {

  private static final String DEFAULT = "Internal error. Database operation did not succeed.";

  public DBOperationException() {
    super(DEFAULT);
  }
}
