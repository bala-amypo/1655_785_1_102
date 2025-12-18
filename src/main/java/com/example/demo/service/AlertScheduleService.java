package com.example.demo.service;

public interface AlertScheduleService{

AlertSchedule createSchedule(Long warrantyId,AlertSchedule schedule);
List<AlertSchedule> getLogs(Long warrantyId);
    
}