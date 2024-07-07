package com.devops.devopsjava.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@Slf4j
@RestController
@RequestMapping("/hello")
public class HelloController {

    @GetMapping("/health")
    ResponseEntity<?> health() {
       var map = Map.of("health","ok");
       return ResponseEntity.ok().body(map);
    }
}
