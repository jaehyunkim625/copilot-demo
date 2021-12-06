package com.example.copilot.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
public class HelloController {
  @GetMapping("/")
  public String greeting() {
    log.info("greeting is called from client...");
    return "This is Hello-Java App (Sample Backend App)";
  } 
}
