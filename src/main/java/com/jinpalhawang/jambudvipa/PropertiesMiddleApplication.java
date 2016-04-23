package com.jinpalhawang.jambudvipa;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@EnableDiscoveryClient
@RestController
public class PropertiesMiddleApplication {

  private static final Logger log = LoggerFactory.getLogger(PropertiesMiddleApplication.class);

  @Autowired
  private DiscoveryClient discoveryClient;

  @RequestMapping("/")
  public String properties() {
    log.info("Hello World!");
    return "Hello World!";
  }

  @RequestMapping("/service-instances/{applicationName}")
  public List<ServiceInstance> serviceInstancesByApplicationName(@PathVariable String applicationName) {
    return this.discoveryClient.getInstances(applicationName);
  }

  public static void main(String[] args) {
    SpringApplication.run(PropertiesMiddleApplication.class, args);
  }

}
