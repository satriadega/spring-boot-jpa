package com.springjpa.demo.controller;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.springjpa.demo.entity.FasterXMLPost;
import com.springjpa.demo.entity.Greeting;
import com.springjpa.demo.service.TestService;

@RestController
@RequestMapping("/api/test")
public class TestController {

  private static final String TEMPLATE = "Hello, %s!";
  private final AtomicLong counter = new AtomicLong();

  @Autowired
  private TestService testService;

  @GetMapping("/hello")
  public String getHello(@RequestParam(value = "name", defaultValue = "World") String name) {
    return String.format("Hello %s!", name);
  }

  @GetMapping("/greeting")
  public Greeting getGreeting(@RequestParam(value = "name", defaultValue = "World") String name) {
    return new Greeting(counter.incrementAndGet(), String.format(TEMPLATE, name));
  }

  @GetMapping("/get-jackson")
  public FasterXMLPost getFasterXMLPost() {
    return testService.fetchFasterXMLPostJPH(); // Jackson converts Post to JSON
  }
}