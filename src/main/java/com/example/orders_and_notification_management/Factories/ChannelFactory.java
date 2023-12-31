package com.example.orders_and_notification_management.Factories;
import com.example.orders_and_notification_management.Models.Account;
import com.example.orders_and_notification_management.NotificationSystem.NotificationChannel;
public abstract class ChannelFactory {
    protected Account account;
    public abstract NotificationChannel createChannel(String receiverInfo);
}
