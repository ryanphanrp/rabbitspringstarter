package com.example.notification.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "notification")
public class Notification {

  @Id
  @GeneratedValue
  private Integer notificationId;
  private Integer userId;
  private String title;
  private String message;
}
