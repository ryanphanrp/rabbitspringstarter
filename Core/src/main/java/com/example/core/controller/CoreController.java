package com.example.core.controller;

import com.example.core.dto.NotificationResponse;
import com.example.core.middleware.MessageHandler;
import com.example.core.middleware.MessageSender;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/core")
@AllArgsConstructor
public class CoreController {
    private final MessageHandler messageHandler;
    private final MessageSender messageSender;

    @GetMapping("/get-user")
    public ResponseEntity<NotificationResponse> getNotification(@RequestParam String notificationId) {
        log.info("Get notificationId: {}", notificationId);
        messageSender.sendMessage(notificationId);
        var notification = messageHandler.receiveMessage();
        return ResponseEntity.ok(notification);
    }
}
