package com.example.laptopshop.controller.client;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;



@Controller
public class CartPageController {
    @GetMapping("/cart")
    public String getMethodName() {
        return "client/cart/CartHome";
    }
    
}
