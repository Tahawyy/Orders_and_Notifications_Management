package com.example.orders_and_notification_management.RestControllers;

import com.example.orders_and_notification_management.Models.Category;
import com.example.orders_and_notification_management.NotificationSystem.Notification;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.orders_and_notification_management.Services.NotificationService;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

@RestController
public class NotificationsController {
    @Autowired
    private NotificationService notificationService;

    @GetMapping("/notifications")
    public ResponseEntity<ArrayList<Map<String, Object>>> getCategories() {
        ArrayList<Map<String, Object>> notifications = new ArrayList<>();
        ArrayList<Notification> notificationsList = notificationService.getNotifications();
        for(Notification notification : notificationsList) {
            Map<String, Object> notificationMap = new HashMap<>();
            notificationMap.put("template", notification.getClass().getSimpleName());
            notificationMap.put("receiver", notification.getChannel().getReceiverInfo());
            notificationMap.put("subject", notification.getSubject());
            notificationMap.put("content", notification.getContent());
            notificationMap.put("channel", notification.getChannel().getClass().getSimpleName());
            notifications.add(notificationMap);
        }
        return ResponseEntity.status(200).body(notifications); // 200 OK
    }
    @GetMapping("/notifications/stats")
    public ResponseEntity<String> getStats() {
        String stats = notificationService.getStatistics();
        return ResponseEntity.status(200).body(stats); // 200 OK
    }
}
