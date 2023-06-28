package com.example.notification.configuration;

import java.util.Arrays;
import java.util.List;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Exchange;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQConfig {

  @Value("${rabbitmq.exchange.name}")
  private String exchange;

  @Value("${rabbitmq.queue.service.name}")
  private String serviceQueue;

  @Value("${rabbitmq.queue.backend.name}")
  private String backendQueue;

  @Value("${rabbitmq.routing.key}")
  private String routing;

  @Bean
  public Queue serviceQueue() {
    return new Queue(serviceQueue);
  }

  @Bean
  public Queue backendQueue() {
    return new Queue(backendQueue);
  }

  @Bean
  public List<Binding> binding() {
    return Arrays.asList(
        BindingBuilder.bind(serviceQueue())
            .to(eventExchange())
            .with(routing).noargs(),
        BindingBuilder.bind(backendQueue())
            .to(eventExchange())
            .with(routing).noargs()
    );
  }

  @Bean
  public Exchange eventExchange() {
    return new TopicExchange(exchange);
  }

  @Bean
  public MessageConverter converter() {
    return new Jackson2JsonMessageConverter();
  }

  @Bean
  public AmqpTemplate amqpTemplate(ConnectionFactory connection) {
    var rabbitTemplate = new RabbitTemplate(connection);
    rabbitTemplate.setMessageConverter(converter());
    return rabbitTemplate;
  }
}
