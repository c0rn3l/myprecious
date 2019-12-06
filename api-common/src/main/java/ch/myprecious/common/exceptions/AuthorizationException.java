package ch.myprecious.common.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.UNAUTHORIZED)
public class AuthorizationException extends MyPreciousException {

  private static final String DEFAULT = "User is not authorized for this operation.";

  public AuthorizationException() {
    super(DEFAULT);
  }
}
