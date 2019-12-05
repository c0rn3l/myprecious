package ch.myprecious.common.model;

import ch.myprecious.common.exceptions.MyPreciousException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Response {

  private ObjectMapper mapper = new ObjectMapper();

  @Override
  public String toString() {
    try {
      return mapper.writeValueAsString(this);
    } catch (JsonProcessingException jpe) {
      throw new MyPreciousException("Unable to convert to String JSON", jpe);
    }
  }
}
