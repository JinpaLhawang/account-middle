package com.jinpalhawang.jambudvipa;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.hateoas.MediaTypes;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.webAppContextSetup;

import java.nio.charset.Charset;

import com.jinpalhawang.jambudvipa.PropertiesMiddleApplication;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = PropertiesMiddleApplication.class)
@WebAppConfiguration
public class PropertiesMiddleApplicationTests {

  private MockMvc mockMvc;

  @Autowired
  private WebApplicationContext webApplicationContext;

  @Autowired
  private ApplicationRepository applicationRepository;

  @Before
  public void setup() throws Exception {
    this.mockMvc = webAppContextSetup(webApplicationContext).build();
    this.applicationRepository.deleteAll();
    this.applicationRepository.save(new Application("test-edge"));
  }

  @Test
  public void properties() throws Exception {
    mockMvc.perform(get("/"))
        .andExpect(status().isOk())
        .andExpect(content().contentType(new MediaType(MediaType.TEXT_PLAIN.getType(),
            MediaType.TEXT_PLAIN.getSubtype(),
            Charset.forName("utf8"))))
        .andExpect(content().string("Hello World!"));
  }

  @Test
  public void applicationsFindByName() throws Exception {
    mockMvc.perform(get("/applications/search/findByName?name=test-edge"))
        .andExpect(status().isOk())
        .andExpect(content().contentType(MediaTypes.HAL_JSON));
  }

  @Test
  public void applicationsFindByNameNotFound() throws Exception {
    mockMvc.perform(get("/applications/search/findByName?name=invalid-edge"))
        .andExpect(status().isNotFound());
  }

}
