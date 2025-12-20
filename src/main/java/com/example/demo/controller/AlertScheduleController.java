package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo.entity.AlertSchedule;
import com.example.demo.service.AlertScheduleService;

@RestController
public class AlertScheduleController {
     @Autowired AlertScheduleService alerts;
   @PostMapping("/create schedule")
   public AlertSchedule sendData7(@RequestBody AlertSchedule alertss){
    return alerts.postdata4(alertss);
   }
@GetMapping("/list schedules for warranty")
public AlertSchedule getalldata7(Long id){
    return alerts.getdata4(id);
}

}
