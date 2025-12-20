package com.example.demo.service.impl;
import com.example.demo.service.AlertScheduleService;
import com.example.demo.entity.AlertSchedule;
import com.example.demo.repository.AlertScheduleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AlertScheduleServiceImpl implements AlertScheduleService {
    
    @Autowired
    private AlertScheduleRepository alertScheduleRepository;

    @Override
    public AlertSchedule postdata4(AlertSchedule alertSchedule) {
        return alertScheduleRepository.save(alertSchedule);
    }

    @Override
    public AlertSchedule getdata4(Long id) {
        return alertScheduleRepository.findById(id).orElse(null);
    }

}