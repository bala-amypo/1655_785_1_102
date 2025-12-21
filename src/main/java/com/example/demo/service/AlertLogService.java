package com.example.demo.service;

import com.example.demo.entity.AlertLog;
import java.util.List;

public interface AlertLogService {
    AlertLog addLog(Long warrantyId, String message);
    List<AlertLog> getLogs(Long warrantyId);
       AlertLog updateAlert(Long id, AlertLog alertLog);
void deleteAlert(Long id);
}
