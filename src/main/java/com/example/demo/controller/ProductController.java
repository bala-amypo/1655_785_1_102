package com.example.demo.controller;

import com.example.demo.entity.Product;
import com.example.demo.service.ProductService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    private final ProductService service;

    public ProductController(ProductService service) {
        this.service = service;
    }

    @PostMapping
    public Product addProduct(@RequestBody Product product) {
        return service.addProduct(product);
    }

    @GetMapping
    public List<Product> getAll() {
        return service.getAllProducts();
    }
       @PutMapping("/{id}")
public Product updateProduct(@PathVariable Long id, @RequestBody Product product) {
    return service.updateProduct(id, product);
}

@DeleteMapping("/{id}")
public String deleteProduct(@PathVariable Long id) {
    service.deleteProduct(id);
    return "Product deleted successfully";
}

}
