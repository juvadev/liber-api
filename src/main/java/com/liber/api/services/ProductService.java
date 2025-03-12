package com.liber.api.services;

import com.liber.api.models.Product;
import com.liber.api.repositories.IProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class ProductService {
    @Autowired
    private IProductRepository productRepository;

    public ArrayList<Product> getProducts () {
        return (ArrayList<Product>) productRepository.findAll();
    }

    public Optional<Product> getProductById (int id) {
        return productRepository.findById(id);
    }

    public Product saveProduct (Product product) {
        return productRepository.save(product);
    }

    public Product updateProductById (int id, Product request) {
        Optional<Product> optionalProduct = productRepository.findById(id);

        if (optionalProduct.isPresent()) {
            Product product = optionalProduct.get();
            product.setSku(request.getSku());
            product.setName(request.getName());
            product.setDescription(request.getDescription());
            product.setBarcode(request.getBarcode());
            product.setPrice(request.getPrice());
            product.setImgUrl(request.getImgUrl());
            product.setCategory(request.getCategory());
            product.setState(request.getState());
            return productRepository.save(product);
        } else {
            throw new RuntimeException("Product not found with id " + id);
        }
    }

    public Boolean deleteProductById (int id) {
        try {
            productRepository.deleteById(id);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
