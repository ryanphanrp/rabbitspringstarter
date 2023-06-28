package com.example.core.middleware;

import com.example.core.dto.NotificationDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class MessageHandler {

  @RabbitListener(queues = "${rabbitmq.queue.backend.name}")
  public void receiveMessage(NotificationDto message) {
    log.info("Received message: {}", message.title());
  }
}
