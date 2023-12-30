package com.example.orders_and_notification_management.NotificationSystem;

import com.example.orders_and_notification_management.Models.Account;
import com.example.orders_and_notification_management.Models.SimpleOrder;

public class ShipmentNotification extends Notification{
    public ShipmentNotification(Account account, NotificationChannel channel, SimpleOrder order) {
        super();
        String subject = "Your order has been shipped!";
        String content = "Your order with this serial number: " + order.getSerialNumber() + " has been shipped!";
        super.setReceiver(account);
        super.setSubject(subject);
        super.setContent(content);
        super.setChannel(channel);
    }
}
