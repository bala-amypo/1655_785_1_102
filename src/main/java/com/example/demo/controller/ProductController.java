package com.example.demo.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import com.example.demo.entity.Product;
import com.example.demo.service.ProductService;

@RestController
public class ProductController {


      @Autowired ProductService prds;
   @PostMapping("/add a product")
   public Product sendData1(@RequestBody Product product){
    return prds.addaproduct(product);
   }
@GetMapping("/list all products")
public List<Product> getalldata(){
    return prds.getalldata();
}
}
