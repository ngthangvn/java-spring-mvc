package com.example.laptopshop;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
public class HelloController {
    @GetMapping("/")
    public String index() {
        return "hello word";
    }
    @GetMapping("/user")
    public String userPage() {
        return "hello word user";
    }
    @GetMapping("/admin")
    public String adminPage() {
        return "hello word admin";
    }
    
}
