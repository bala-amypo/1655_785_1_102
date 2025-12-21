package com.example.demo.service;

import com.example.demo.entity.AlertSchedule;
import java.util.List;

public interface AlertScheduleService {
    AlertSchedule createSchedule(Long warrantyId, AlertSchedule schedule);
    List<AlertSchedule> getSchedules(Long warrantyId);
        AlertSchedule updateSchedule(Long id, AlertSchedule schedule);
void deleteSchedule(Long id);
}
