package com.example.laptopshop.controller.client;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.laptopshop.domain.Product;
import com.example.laptopshop.service.ProductService;


@Controller
public class IteamController {

    private final ProductService productService;

    public IteamController(ProductService productService){
        this.productService = productService;
    }
    
    @GetMapping("/product/{id}")
    public String getDetail(Model model, @PathVariable long id) {
        Product product = this.productService.getProductById(id);
        model.addAttribute("id", id);
        model.addAttribute("product", product);
        return "client/product/detail";
    }
    
}
