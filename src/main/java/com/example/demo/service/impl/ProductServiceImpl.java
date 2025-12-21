package com.example.demo.service.impl;

import com.example.demo.entity.Product;
import com.example.demo.repository.ProductRepository;
import com.example.demo.service.ProductService;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ProductServiceImpl implements ProductService {

    private final ProductRepository repo;

    public ProductServiceImpl(ProductRepository repo) {
        this.repo = repo;
    }

    @Override
    public Product addProduct(Product product) {
        if (product.getModelNumber() == null) {
            throw new RuntimeException("Model number required");
        }
        return repo.save(product);
    }

    @Override
    public List<Product> getAllProducts() {
        return repo.findAll();
    }
        @Override
public Product updateProduct(Long id, Product product) {
    Product existing = repo.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("Product not found"));

    existing.setName(product.getName());
    existing.setCategory(product.getCategory());

    return repo.save(existing);
}

@Override
public void deleteProduct(Long id) {
    Product product = repo.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("Product not found"));
    repo.delete(product);
}

}
