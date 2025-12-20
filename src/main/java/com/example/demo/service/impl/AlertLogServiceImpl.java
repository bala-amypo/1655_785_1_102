package com.example.demo.service.impl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.AlertLog;
import com.example.demo.repository.AlertLogRepository;
import com.example.demo.service.AlertLogService;

@Service
public class AlertLogServiceImpl implements AlertLogService {
    
  
    @Autowired
    private AlertLogRepository alertLogRepository;

    @Override
    public AlertLog postdata5(AlertLog alertLog) {
        return alertLogRepository.save(alertLog);
    }

    @Override
    public AlertLog getdata5(Long id) {
        return alertLogRepository.findById(id).orElse(null);
    }

}
