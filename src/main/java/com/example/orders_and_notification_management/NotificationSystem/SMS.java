package com.example.orders_and_notification_management.NotificationSystem;

public class SMS implements NotificationChannel{
    @Override
    public boolean sendNotification(Notification notification) {
        return true;
    }
}
