package ch.myprecious.common.helper;

import org.springframework.http.HttpStatus;

@FunctionalInterface
public interface RestCaller<T> {

  T execute(HttpStatus httpStatus, Object... args);
}
