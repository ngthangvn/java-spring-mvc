package com.example.laptopshop.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.laptopshop.service.UserService;
import com.example.laptopshop.domain.User;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class UserController {

    private UserService userService;

    public UserController(UserService userService) {
    this.userService = userService;
    }

    @RequestMapping("/admin/user")
    public String getHomePage(Model model) {
        String test = this.userService.handlHello();
        model.addAttribute("newUser", new User());
        model.addAttribute("hoidanit", "hãy hỏi dan it");
        return "admin/user/CreateUser";
    }

    @RequestMapping(value = "/admin/user/create", method = RequestMethod.POST)
    public String adminUser(Model model, @ModelAttribute User tenBien) {
        System.out.println("run here"+tenBien);
        return "hello";
    }
}

// @RestController
// public class UserController {

// // DI: dependency injection
// private UserService userService;

// public UserController(UserService userService) {
// this.userService = userService;
// }

// @GetMapping("/")
// public String getHomePage(){
// return this.userService.handlHello();
// }
// }
