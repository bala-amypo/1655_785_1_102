package com.example.demo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Warranty;
import com.example.demo.service.WarrantyService;
import com.example.demo.repository.WarrantyRepository;
import com.example.demo.exception.ResourceNotFoundException;

@Service
public class WarrantyServiceImpl implements WarrantyService {

    @Autowired 
    private WarrantyRepository warran;

    @Override
    public Warranty postdata2(Warranty warranty){

        if (!warranty.getExpiryDate().isAfter(warranty.getPurchaseDate())) {
            throw new IllegalArgumentException(
                "Expiry date must be after purchase date"
            );
        }

        if (warran.existsBySerialNumber(warranty.getSerialNumber())) {
            throw new IllegalArgumentException(
                "Serial number must be unique"
            );
        }

        return warran.save(warranty);
    }

    @Override
    public Warranty getdata1(Long id){
        return warran.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Warranty not found")
                );
    }

    @Override
    public List<Warranty> getalldatas(){
        return warran.findAll();
    }

    @Override
    public void delete1(Long id) {
        warran.deleteById(id);
    }
}