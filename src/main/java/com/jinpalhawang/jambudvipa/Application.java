package com.jinpalhawang.jambudvipa;

import org.springframework.data.annotation.Id;

public class Application {

  @Id
  private String id;

  private String name;

  public Application() {}

  public Application(String name) {
    this.name = name;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

}
