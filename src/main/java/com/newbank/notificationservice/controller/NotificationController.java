package com.newbank.notificationservice.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/notifications")
@Slf4j
public class NotificationController {

    @PostMapping("/send")
    public ResponseEntity<Map<String, String>> sendNotification(@RequestBody Map<String, String> payload) {
        log.info("Sending notification: {}", payload);
        String message = payload.getOrDefault("message", "Notification sent successfully");
        return ResponseEntity.ok(Map.of(
                "status", "queued",
                "message", message
        ));
    }

    @GetMapping("/health")
    public ResponseEntity<Map<String, String>> health() {
        return ResponseEntity.ok(Map.of("status", "Notification Service is running"));
    }
}
