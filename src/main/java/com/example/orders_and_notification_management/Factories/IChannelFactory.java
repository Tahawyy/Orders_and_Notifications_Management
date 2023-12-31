package com.example.orders_and_notification_management.Factories;

import com.example.orders_and_notification_management.Models.Account;
import com.example.orders_and_notification_management.NotificationSystem.NotificationChannel;

public interface IChannelFactory {
    public NotificationChannel createChannel(Account account);
}
