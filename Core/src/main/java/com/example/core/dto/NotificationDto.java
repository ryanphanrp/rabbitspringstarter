package com.example.core.dto;

public record NotificationDto(Integer notificationId, Integer userId, String title,
                              String message) {
}
