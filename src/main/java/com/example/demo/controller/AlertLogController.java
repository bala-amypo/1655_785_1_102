package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo.entity.AlertLog;
import com.example.demo.service.AlertLogService;


@RestController
public class AlertLogController {

         @Autowired AlertLogService alertlog;
   @PostMapping("/add alert logs")
   public AlertLog sendDatas(@RequestBody AlertLog alertsss){
    return alertlog.postdata5(alertsss);
   }
@GetMapping("/view alert log")
public AlertLog getalldatas(Long id){
    return alertlog.getdata5(id);
}


}
