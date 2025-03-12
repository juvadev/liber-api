package com.liber.api.controllers;

import com.liber.api.models.Product;
import com.liber.api.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Optional;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping
    public ArrayList<Product> getProducts () {
        return productService.getProducts();
    }

    @GetMapping("/{id}")
    public Optional<Product> getProductById (@PathVariable int id) {
        return productService.getProductById(id);
    }

    @PostMapping("/save")
    public Product saveProduct (@RequestBody Product product) {
        return productService.saveProduct(product);
    }

    @PutMapping("/update/{id}")
    public Product updateProductById (@PathVariable int id, @RequestBody Product request) {
        return productService.updateProductById(id, request);
    }

    @DeleteMapping("/delete/{id}")
    public Boolean deleteProductById (@PathVariable int id) {
        return productService.deleteProductById(id);
    }
}
