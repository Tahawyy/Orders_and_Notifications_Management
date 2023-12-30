package com.example.orders_and_notification_management.Services;

import com.example.orders_and_notification_management.Models.Account;
import com.example.orders_and_notification_management.Models.SimpleOrder;
import com.example.orders_and_notification_management.NotificationSystem.*;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

@Service
public class NotificationService {
    Queue<Notification> notifications;

    public NotificationService() {
        notifications = new LinkedList<>();
    }
    public void sendPlacementNotification(Account account, SimpleOrder order) {
        NotificationChannel channel = new EMail();
        notifications.add(new PlacementNotification(account, channel, order));
    }
    public void sendShipmentNotification(Account account, SimpleOrder order) {
        NotificationChannel channel = new EMail();
        notifications.add(new ShipmentNotification(account, channel, order));
    }
    public ArrayList<Notification> getNotifications() {
        ArrayList<Notification> notificationsList = new ArrayList<>();
        for(Notification notification : notifications) {
            notificationsList.add(notification);
        }
        return notificationsList;
    }
}
