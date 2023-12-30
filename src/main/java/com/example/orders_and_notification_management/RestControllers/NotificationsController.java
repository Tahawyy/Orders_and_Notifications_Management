package com.example.orders_and_notification_management.RestControllers;

import com.example.orders_and_notification_management.Models.Category;
import com.example.orders_and_notification_management.NotificationSystem.Notification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.orders_and_notification_management.Services.NotificationService;

import java.util.ArrayList;

@RestController
public class NotificationsController {
    @Autowired
    private NotificationService notificationService;

    @GetMapping("/notifications")
    public ResponseEntity<ArrayList<String>> getCategories() {
        ArrayList<Notification> notifications = notificationService.getNotifications();
        ArrayList<String> notificationsContent = new ArrayList<>();
        for(Notification notification : notifications) {
            notificationsContent.add(notification.getContent());
        }
        return ResponseEntity.status(200).body(notificationsContent); // 200 OK
    }
}
