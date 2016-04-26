package com.jinpalhawang.jambudvipa;

import java.util.Map;

import org.springframework.data.annotation.Id;

public class Application {

  @Id
  private String id;

  private String name;
  private String property;
  private Map<String, String> properties;

  public Application() {}

  public Application(String name, String property, Map<String, String> properties) {
    this.name = name;
    this.property = property;
    this.properties = properties;
  }

  public String getName() {
    return name;
  }

  public String getProperty() {
    return property;
  }

  public Map<String, String> getProperties() {
    return properties;
  }

  public void setName(String name) {
    this.name = name;
  }

  public void setProperty(String property) {
    this.property = property;
  }

  public void setProperties(Map<String, String> properties) {
    this.properties = properties;
  }

}
