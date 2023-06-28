package com.example.notification.service;

import com.example.notification.dto.NotificationCreateDto;
import com.example.notification.model.NotificationDao;
import com.example.notification.model.NotificationDto;
import java.util.List;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class NotificationService {

  private final NotificationDao notificationDao;

  public NotificationDto findBy(Integer notificationId) {
    return notificationDao.findById(notificationId)
        .map(NotificationDto::from)
        .orElseThrow();
  }

  public List<NotificationDto> findAll() {
    return notificationDao.findAll()
        .stream()
        .map(NotificationDto::from)
        .toList();
  }

  public NotificationDto createNotification(NotificationCreateDto dto) {
    return NotificationDto.from(notificationDao.save(dto.toEntity()));
  }
}
