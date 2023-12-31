package com.example.notification.middleware;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class MessageSender {
  private final RabbitTemplate rabbitTemplate;

  @Value("${rabbitmq.queue.backend.name}")
  private String queueName;

  public MessageSender(RabbitTemplate rabbitTemplate) {
    this.rabbitTemplate = rabbitTemplate;
  }

  public void sendMessage(Object event) {
    log.info("Sending message: {}", event);
    rabbitTemplate.convertAndSend(queueName, event);
  }
}
