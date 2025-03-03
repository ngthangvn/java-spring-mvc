package com.example.laptopshop.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.laptopshop.domain.Product;
import com.example.laptopshop.repository.ProductRepository;

@Service
public class ProductService {
    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }
    
    public List<Product> getAllProducts(){
        return this.productRepository.findAll();
    }

    public Product getProductSave(Product product){
        Product eric = this.productRepository.save(product);
        System.out.println(eric);
        return eric;
    }

    public Product getProductById(long id){
        return this.productRepository.findById(id);
    }

    public void deleteProductById(long id){
        this.productRepository.deleteById(id);
    }
}
