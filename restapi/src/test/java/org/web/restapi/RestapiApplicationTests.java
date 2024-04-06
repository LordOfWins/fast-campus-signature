package org.web.restapi;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.web.restapi.model.UserRequest;

import static org.junit.jupiter.api.Assertions.assertEquals;


@SpringBootTest
class RestapiApplicationTests {

  @Autowired
  private ObjectMapper objectMapper;

  @Test
  void testContextLoads() throws JsonProcessingException {
    var user = new UserRequest("steve", 23, "010-1111-2222", true);
    user.setUserName("steve");
    user.setUserAge(23);
    user.setEmail("010-1111-2222");
    user.setIsKorean(true);

    var json = objectMapper.writeValueAsString(user);
    System.out.println(json);

    var userObject = objectMapper.readValue(json, UserRequest.class);
    System.out.println(userObject);

    assertEquals(user.getUserName(), userObject.getUserName(), "user name is not same");
  }

}