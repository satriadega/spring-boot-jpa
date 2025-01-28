package com.springjpa.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.springjpa.demo.entity.FasterXMLPost;

@Service
public class TestService {

  @Autowired
  private RestTemplate restTemplate;

  public FasterXMLPost fetchFasterXMLPostJPH() {
    String API_URL = "https://jsonplaceholder.typicode.com/posts/1";
    return restTemplate.getForObject(API_URL, FasterXMLPost.class); // Jackson maps JSON to Post
  }
}
