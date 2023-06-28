package com.example.notification.middleware;

import com.example.notification.service.NotificationService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@AllArgsConstructor
public class MessageHandler {
  private final NotificationService notificationService;
  private final MessageSender messageSender;

  @RabbitListener(queues = "${rabbitmq.queue.service.name}")
  public void receiveMessage(Integer message) {
    log.info("Received message: {}", message);
    var notification = notificationService.findBy(message);
    log.info("Notification: {}", notification);
    messageSender.sendMessage(notification);
  }
}
