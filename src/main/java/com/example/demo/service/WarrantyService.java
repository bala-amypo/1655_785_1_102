package com.example.demo.service;

public interface WarrantyService{

    Warranty registerWarranty(Long userId,Long productId,Warranty warranty);
    Warranty getWarranty(Long warrantyId);
    List<Product>getUserWarranties(Long userId);
}