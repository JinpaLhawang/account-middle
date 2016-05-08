package com.jinpalhawang.jambudvipa.accountmiddle;

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

import com.jinpalhawang.jambudvipa.accountmiddle.Account;
import com.jinpalhawang.jambudvipa.accountmiddle.AccountMiddleApplication;
import com.jinpalhawang.jambudvipa.accountmiddle.AccountRepository;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.webAppContextSetup;

import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.Map;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = AccountMiddleApplication.class)
@WebAppConfiguration
public class AccountMiddleApplicationTests {

  private MockMvc mockMvc;

  @Autowired
  private WebApplicationContext webApplicationContext;

  @Autowired
  private AccountRepository accountRepository;

  @Before
  public void setup() throws Exception {
    this.mockMvc = webAppContextSetup(webApplicationContext).build();
    this.accountRepository.deleteAll();
    Map<String, String> tags = new HashMap<String, String>();
    tags.put("debug1", "I used to say Hello World!");
    tags.put("debug2", "Now I say Hello Jinpa Lhawang!");
    this.accountRepository.save(new Account("Jinpa", "Lhawang", tags));
  }

  @Test
  public void helloWorld() throws Exception {
    mockMvc.perform(get("/"))
        .andExpect(status().isOk())
        .andExpect(content().contentType(new MediaType(MediaType.TEXT_PLAIN.getType(),
            MediaType.TEXT_PLAIN.getSubtype(),
            Charset.forName("utf8"))))
        .andExpect(content().string("Hello World!"));
  }

  @Test
  public void applicationsFindByName() throws Exception {
    mockMvc.perform(get("/accounts/search/findByFirstName?firstName=Jinpa"))
        .andExpect(status().isOk())
        .andExpect(content().contentType(MediaTypes.HAL_JSON));
  }

  @Test
  public void applicationsFindByNameNotFound() throws Exception {
    mockMvc.perform(get("/accounts/search/findByFirstName?firstName=invalid"))
        .andExpect(status().isNotFound());
  }

}
