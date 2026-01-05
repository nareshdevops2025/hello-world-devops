package com.example.hello;
@RestController
public class HelloController {

    @GetMapping("/")
    public String hello() {
        return "Hello World from Kubernetes 🚀";
    }
}
