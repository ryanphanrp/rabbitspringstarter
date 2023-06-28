package com.example.notification.model;

public record NotificationDto(Integer notificationId, Integer userId, String title,
                              String message) {

  public static NotificationDto from(Notification notification) {
    return new NotificationDto(
        notification.getNotificationId(),
        notification.getUserId(),
        notification.getTitle(),
        notification.getMessage()
    );
  }
}
