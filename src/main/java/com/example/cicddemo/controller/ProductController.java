package com.example.cicddemo.controller;

import com.example.cicddemo.entity.Product;
import com.example.cicddemo.service.ProductService;

import lombok.AllArgsConstructor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/products")
public class ProductController {

	@Autowired
    private final ProductService productService;

    @GetMapping
    public List<Product> getProducts() {

        return productService.getAllProducts();
    }

    @PostMapping
    public Product createProduct(@RequestBody Product product) {

        return productService.saveProduct(product);
    }
}