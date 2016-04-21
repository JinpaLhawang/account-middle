package com.jinpalhawang.jambudvipa;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class PropertiesMiddleApplication {

  private static final Logger log = LoggerFactory.getLogger(PropertiesMiddleApplication.class);

  @RequestMapping("/")
  public String properties() {
    log.info("Hello World!");
    return "Hello World!";
  }

  public static void main(String[] args) {
    SpringApplication.run(PropertiesMiddleApplication.class, args);
  }

}
