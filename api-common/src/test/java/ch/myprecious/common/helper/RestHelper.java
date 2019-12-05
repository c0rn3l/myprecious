package ch.myprecious.common.helper;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import ch.myprecious.common.exceptions.MyPreciousException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

@Component
public class RestHelper {

  private ObjectMapper mapper = new ObjectMapper();
  private MockMvc mockMvc;

  @Autowired
  public RestHelper(WebApplicationContext wac) {
    mockMvc = MockMvcBuilders.webAppContextSetup(wac).build();
  }

  public <T> RestCaller<T> createGetCaller(Class<T> aClass, String uri) {
    return (status, args) -> {
      try {
        MvcResult result = mockMvc.perform(MockMvcRequestBuilders.get(uri, args))
            .andExpect(status().is(status.value())).andReturn();
        String jsonResponse = result.getResponse().getContentAsString();
        if (!jsonResponse.isEmpty()) {
          return mapper.readValue(jsonResponse, aClass);
        } else {
          return null;
        }
      } catch (Exception ex) {
        throw new MyPreciousException(ex);
      }
    };
  }
}