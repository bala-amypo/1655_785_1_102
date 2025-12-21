package com.example.demo.service.impl;

import com.example.demo.entity.*;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.repository.*;
import com.example.demo.service.WarrantyService;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class WarrantyServiceImpl implements WarrantyService {

    private final WarrantyRepository warrantyRepo;
    private final UserRepository userRepo;
    private final ProductRepository productRepo;

    public WarrantyServiceImpl(WarrantyRepository w, UserRepository u, ProductRepository p) {
        this.warrantyRepo = w;
        this.userRepo = u;
        this.productRepo = p;
    }

    @Override
    public Warranty registerWarranty(Long userId, Long productId, Warranty warranty) {

        if (warrantyRepo.existsBySerialNumber(warranty.getSerialNumber())) {
            throw new RuntimeException("Serial number must be unique");
        }

        if (warranty.getExpiryDate().isBefore(warranty.getPurchaseDate())) {
            throw new RuntimeException("Expiry date must be after purchase date");
        }

        User user = userRepo.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException("User not found"));
        Product product = productRepo.findById(productId)
                .orElseThrow(() -> new ResourceNotFoundException("Product not found"));

        warranty.setUser(user);
        warranty.setProduct(product);

        return warrantyRepo.save(warranty);
    }

    @Override
    public Warranty getWarranty(Long warrantyId) {
        return warrantyRepo.findById(warrantyId)
                .orElseThrow(() -> new ResourceNotFoundException("Warranty not found"));
    }

    @Override
    public List<Warranty> getUserWarranties(Long userId) {
        return warrantyRepo.findByUserId(userId);
    }

    @Override
public Warranty updateWarranty(Long id, Warranty warranty) {
    Warranty existing = warrantyRepo.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("Warranty not found"));

    existing.setProduct(warranty.getProduct());
    existing.setUser(warranty.getUser());
    existing.setPurchaseDate(warranty.getPurchaseDate());
    existing.setExpiryDate(warranty.getExpiryDate());
    existing.setSerialNumber(warranty.getSerialNumber());

    return warrantyRepo.save(existing);
}

@Override
public void deleteWarranty(Long id) {
    Warranty warranty = warrantyRepo.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("Warranty not found"));
    warrantyRepo.delete(warranty);
}

}
