package ch.myprecious.common.exceptions;

public class MyPreciousException extends RuntimeException {

  public MyPreciousException(String message) {
    super(message);
  }

  public MyPreciousException(Exception ex) {
    super(ex.getMessage(), ex.getCause());
  }

  public MyPreciousException(String message, Throwable cause) {
    super(message, cause);
  }
}
