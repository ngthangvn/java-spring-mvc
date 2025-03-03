package com.example.laptopshop.controller.admin;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.laptopshop.domain.Product;
import com.example.laptopshop.service.ProductService;
import com.example.laptopshop.service.UploadService;
import com.fasterxml.jackson.annotation.JsonCreator.Mode;

import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;



@Controller
public class ProductController {
    private final ProductService productService;
    private final UploadService uploadService;
    
    public ProductController(ProductService productService, UploadService uploadService) {
        this.productService = productService;
        this.uploadService = uploadService;
    }

    @RequestMapping("/admin/product")
    public String getDashboard(Model model){
        List<Product> products = this.productService.getAllProducts();
        model.addAttribute("product1", products);   
        return "admin/product/show";
    }

    @GetMapping("/admin/product/{id}")
    public String getDetailProduct(Model model, @PathVariable long id) {
        Product product = this.productService.getProductById(id);
        model.addAttribute("product", product);
        model.addAttribute("id", id);
        return "/admin/product/detail";
    }
    

    @GetMapping("/admin/product/create")
    public String getCreateProductPage(Model model) {
        model.addAttribute("newProduct", new Product());
        return "admin/product/create";
    }

    @PostMapping(value = "/admin/product/create")
    public String createProduct(Model model, @ModelAttribute("newProduct") @Valid Product product, BindingResult newProductBindingResult, @RequestParam("uploadFileProduct") MultipartFile file) {
                    List<FieldError> errors = newProductBindingResult.getFieldErrors();
            for (FieldError error : errors) {
                System.out.println(">>>"+ error.getField()+" - "+ error.getDefaultMessage());
            }
            // validate
            if (newProductBindingResult.hasErrors()) {
                return "admin/product/create";            
            }

        String image = this.uploadService.handleSaveUploadFile(file, "product");
        product.setImage(image);
        this.productService.getProductSave(product);
        return "redirect:/admin/product";
    }
    
    @GetMapping("/admin/product/update/{id}")
    public String getUpdateProductPage(Model model, @PathVariable long id){
        Product currenProduct = this.productService.getProductById(id);
        model.addAttribute("newProduct", currenProduct);
        return "admin/product/update";
    }

    @PostMapping(value = "/admin/product/update")
    public String updateProduct(Model model, @ModelAttribute("newProduct") @Valid Product product, BindingResult newProductBindingResult, @RequestParam("uploadFileProduct") MultipartFile file){
        
        // validate
        if (newProductBindingResult.hasErrors()) {
            return "admin/product/create";            
        }
        Product currenProduct = this.productService.getProductById(product.getId());
        if(currenProduct != null){
            if (!file.isEmpty() ) {
                String image = this.uploadService.handleSaveUploadFile(file, "product");
                currenProduct.setImage(image);
            }
            currenProduct.setName(product.getName());
            currenProduct.setPrice(product.getPrice());
            currenProduct.setQuantity(product.getQuantity());
            currenProduct.setDetailDesc(product.getDetailDesc());
            currenProduct.setFactory(product.getFactory());
            currenProduct.setShortDesc(product.getShortDesc());
            currenProduct.setSold(product.getSold());
            currenProduct.setTarget(product.getTarget());

            this.productService.getProductSave(currenProduct);
        }
        return "redirect:/admin/product";
    }

    @GetMapping("/admin/product/delete/{id}")
    public String getDeleteProductPage(Model model, @PathVariable long id){
        Product deleteProduct = this.productService.getProductById(id);
        model.addAttribute("newProduct", deleteProduct);
        return "admin/product/delete";
    }

    @PostMapping(value = "/admin/product/delete")
    public String postMethodName(Mode mode, @ModelAttribute Product product) {
        this.productService.deleteProductById(product.getId());
        return "redirect:/admin/product";
    }
    
}
