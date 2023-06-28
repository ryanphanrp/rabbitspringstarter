package com.example.notification.dto;

import com.example.notification.model.Notification;

public record NotificationCreateDto(Integer userId, String title, String message) {
  public Notification toEntity() {
    Notification notification = new Notification();
    notification.setUserId(userId);
    notification.setTitle(title);
    notification.setMessage(message);
    return notification;
  }
}
