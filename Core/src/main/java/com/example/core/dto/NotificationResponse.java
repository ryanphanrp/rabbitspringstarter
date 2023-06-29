package com.example.core.dto;

import java.io.Serializable;

public record NotificationResponse(Integer notificationId, Integer userId, String title,
                                   String message) implements Serializable {
}
