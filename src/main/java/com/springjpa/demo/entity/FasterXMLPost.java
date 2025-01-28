package com.springjpa.demo.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import lombok.Data;

@Data // Lombok annotation for getters, setters, toString, etc.
public class FasterXMLPost {
  @JsonProperty("userId") // Maps JSON field "userId" to this property
  private Long userId;

  @JsonPropertyOrder("id")
  private Long id;

  @JsonProperty("title")
  private String title;

  @JsonProperty("body")
  private String body;
}