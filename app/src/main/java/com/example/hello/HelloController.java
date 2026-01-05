package com.example.hello;
package org.springframework.web.bind.annotation.RestController
@RestController
public class HelloController {

    @GetMapping("/")
    public String hello() {
        return "Hello World from Kubernetes 🚀";
    }
}
