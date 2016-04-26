package com.jinpalhawang.jambudvipa;

import org.springframework.data.annotation.Id;

public class Application {

  @Id
  private String id;

  private String name;
  private String property;

  public Application() {}

  public Application(String name, String property) {
    this.name = name;
    this.property = property;
  }

  public String getName() {
    return name;
  }

  public String getProperty() {
    return property;
  }

  public void setName(String name) {
    this.name = name;
  }

  public void setProperty(String property) {
    this.property = property;
  }

}
