
package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.Warranty;

public interface WarrantyService {

    Warranty postdata2(Warranty warranty);

    Warranty getdata1(Long id);

    List<Warranty> getalldatas();

    void delete1(Long id);
}