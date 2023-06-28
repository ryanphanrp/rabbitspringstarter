package com.example.notification.controller;

import com.example.notification.dto.NotificationCreateDto;
import com.example.notification.model.NotificationDto;
import com.example.notification.service.NotificationService;
import java.util.List;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RequestMapping("/notification")
@RestController
public class NotificationController {

  private final NotificationService service;

  @PostMapping
  public ResponseEntity<Integer> create(@RequestBody NotificationCreateDto dto) {
    NotificationDto savedNotification = service.createNotification(dto);
    return ResponseEntity.ok(savedNotification.notificationId());
  }

  @GetMapping
  public ResponseEntity<List<NotificationDto>> getAll() {
    return ResponseEntity.ok(service.findAll());
  }
}
