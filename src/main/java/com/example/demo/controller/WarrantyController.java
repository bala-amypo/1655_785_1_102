package com.example.demo.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.demo.entity.Warranty;
import com.example.demo.service.WarrantyService;

@RestController
public class WarrantyController {

  @Autowired WarrantyService warrans;

   @PostMapping("/register-warranty")
   public Warranty sendData2(@RequestBody Warranty warranty){
    return warrans.postdata2(warranty);
   }

  @GetMapping("/get-warranty/{id}")
   public Warranty getdata2(@PathVariable Long id){
    return warrans.getdata1(id);
   }
@GetMapping("/list-all-products")
public List<Warranty> getalldata3(){
    return warrans.getalldatas();
}

}
