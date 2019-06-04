package com.jumia.controller;

import static org.mockito.Mockito.when;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.jumia.service.CustomerService;
import java.util.ArrayList;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@RunWith(SpringRunner.class)
@WebMvcTest(MainController.class)
public class MainControllerTest {

  @MockBean
  CustomerService customerService;

  ObjectMapper mapper = new ObjectMapper();

  @Autowired
  private MockMvc mockMvc;

  @Test
  public void itShouldReturnHomePage() throws Exception {
    when(customerService.getCustomers()).thenReturn(new ArrayList<>());

    ResultMatcher ok = MockMvcResultMatchers.status()
        .isOk();

    MockHttpServletRequestBuilder builder = MockMvcRequestBuilders.get("/");
    this.mockMvc.perform(builder)
        .andExpect(ok);
  }

}