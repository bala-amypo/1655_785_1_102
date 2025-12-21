package com.example.demo.controller;

import com.example.demo.entity.AlertLog;
import com.example.demo.service.AlertLogService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/alerts/logs")
public class AlertLogController {

    private final AlertLogService service;

    public AlertLogController(AlertLogService service) {
        this.service = service;
    }

    @PostMapping("/{warrantyId}")
    public AlertLog addLog(@PathVariable Long warrantyId,
                           @RequestBody String message) {
        return service.addLog(warrantyId, message);
    }

    @GetMapping("/{warrantyId}")
    public List<AlertLog> getLogs(@PathVariable Long warrantyId) {
        return service.getLogs(warrantyId);
    }
    @PutMapping("/{id}")
public AlertLog updateAlert(@PathVariable Long id, @RequestBody AlertLog alertLog) {
    return service.updateAlert(id, alertLog);
}

@DeleteMapping("/{id}")
public String deleteAlert(@PathVariable Long id) {
    service.deleteAlert(id);
    return "Alert deleted successfully";
}
}
