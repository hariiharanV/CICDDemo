package com.example.cicddemo.controller;

import com.example.cicddemo.controller.ProductController;
import com.example.cicddemo.entity.Product;
import com.example.cicddemo.service.ProductService;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(ProductController.class)
class ProductControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ProductService productService;

    @Test
    void shouldGetProducts() throws Exception {
	
        when(productService.getAllProducts())
                .thenReturn(List.of(
                        new Product("Laptop", 75000.0)
                ));

        mockMvc.perform(get("/api/products"))
                .andExpect(status().isOk());
    }
}