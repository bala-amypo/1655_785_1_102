package com.example.demo.service.impl;

import com.example.demo.entity.AlertSchedule;
import com.example.demo.entity.Warranty;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.repository.AlertScheduleRepository;
import com.example.demo.repository.WarrantyRepository;
import com.example.demo.service.AlertScheduleService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class AlertScheduleServiceImpl implements AlertScheduleService {

    private final AlertScheduleRepository scheduleRepo;
    private final WarrantyRepository warrantyRepo;

    public AlertScheduleServiceImpl(AlertScheduleRepository scheduleRepo,
                                    WarrantyRepository warrantyRepo) {
        this.scheduleRepo = scheduleRepo;
        this.warrantyRepo = warrantyRepo;
    }

    @Override
    public AlertSchedule createSchedule(Long warrantyId, AlertSchedule schedule) {

        Warranty warranty = warrantyRepo.findById(warrantyId)
                .orElseThrow(() -> new ResourceNotFoundException("Warranty not found"));

        scheduleRepo.setWarranty(warranty);
        scheduleRepo.setEnabled(true);

        return scheduleRepo.save(schedule);
    }

    @Override
    public List<AlertSchedule> getSchedules(Long warrantyId) {
        return scheduleRepo.findByWarrantyId(warrantyId);
    }
     @Override
public AlertSchedule updateSchedule(Long id, AlertSchedule schedule) {
    AlertSchedule existing = scheduleRepo.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("Schedule not found"));

    existing.setAlertDate(schedule.getAlertDate());
    existing.setWarranty(schedule.getWarranty());

    return scheduleRepo.save(existing);
}

@Override
public void deleteSchedule(Long id) {
    AlertSchedule schedule = scheduleRepo.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("Schedule not found"));
    scheduleRepo.delete(schedule);
}
}