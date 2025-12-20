package com.example.demo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Product;
import com.example.demo.repository.ProductRepository;
import com.example.demo.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository prod;

    @Override
    public Product addaproduct(Product product) {

        if (product.getModelNumber() == null || product.getModelNumber().trim().isEmpty()) {
            throw new IllegalArgumentException("Model number required");
        }

        if (product.getCategory() == null || product.getCategory().trim().isEmpty()) {
            throw new IllegalArgumentException("Category required");
        }

        return prod.save(product);
    }

    @Override
    public List<Product> getalldata() {
        return prod.findAll();
    }
}