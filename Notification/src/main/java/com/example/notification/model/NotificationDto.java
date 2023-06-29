package com.example.notification.model;

import java.io.Serializable;

public record NotificationDto(Integer notificationId, Integer userId, String title,
                              String message) implements Serializable {

  public static NotificationDto from(Notification notification) {
    return new NotificationDto(
        notification.getNotificationId(),
        notification.getUserId(),
        notification.getTitle(),
        notification.getMessage()
    );
  }
}
