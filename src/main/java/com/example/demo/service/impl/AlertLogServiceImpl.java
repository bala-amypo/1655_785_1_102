package com.example.demo.service.impl;

import com.example.demo.entity.AlertLog;
import com.example.demo.entity.Warranty;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.repository.AlertLogRepository;
import com.example.demo.repository.WarrantyRepository;
import com.example.demo.service.AlertLogService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AlertLogServiceImpl implements AlertLogService {

    private final AlertLogRepository logRepo;
    private final WarrantyRepository warrantyRepo;

    public AlertLogServiceImpl(AlertLogRepository logRepo,
                               WarrantyRepository warrantyRepo) {
        this.logRepo = logRepo;
        this.warrantyRepo = warrantyRepo;
    }

    @Override
    public AlertLog addLog(Long warrantyId, String message) {

        Warranty warranty = warrantyRepo.findById(warrantyId)
                .orElseThrow(() -> new ResourceNotFoundException("Warranty not found"));

        AlertLog log = AlertLog.builder()
                .warranty(warranty)
                .message(message)
                .build();

        return logRepo.save(log);
    }

    @Override
    public List<AlertLog> getLogs(Long warrantyId) {
        return logRepo.findByWarrantyId(warrantyId);
    }
     @Override
public AlertLog updateAlert(Long id, AlertLog alertLog) {
    AlertLog existing = logRepo.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("Alert not found"));

    existing.setMessage(alertLog.getMessage());
    existing.setSentAt(alertLog.getSentAt());

    return logRepo.save(existing);
}

@Override
public void deleteAlert(Long id) {
    AlertLog alert = logRepo.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("Alert not found"));
    logRepo.delete(alert);
}
}
