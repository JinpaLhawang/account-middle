package com.jinpalhawang.jambudvipa.accountmiddle;

import java.util.Map;

import org.springframework.data.annotation.Id;

public class Account {

  @Id
  private String id;

  private String firstName;
  private String lastName;
  private Map<String, String> tags;

  public Account() {}

  public Account(String firstName, String lastName, Map<String, String> tags) {
    this.firstName = firstName;
    this.lastName = lastName;
    this.tags = tags;
  }

  public String getFirstName() {
    return firstName;
  }

  public String getLastName() {
    return lastName;
  }

  public String getFullName() {
    return getFirstName() + " " + getLastName();
  }

  public Map<String, String> getTags() {
    return tags;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  public void setTags(Map<String, String> tags) {
    this.tags = tags;
  }

  @Override
  public String toString() {
    return "[" + firstName + " " + lastName + "] Tags: " + tags.size();
  }

}
