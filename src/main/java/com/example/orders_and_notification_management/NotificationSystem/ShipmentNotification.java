package com.example.orders_and_notification_management.NotificationSystem;

import com.example.orders_and_notification_management.Models.Account;
import com.example.orders_and_notification_management.Models.SimpleOrder;

public class ShipmentNotification extends Notification{
    private SimpleOrder order;
    private static String subject = "Your order has been shipped";
    public ShipmentNotification(Account account, NotificationChannel channel, SimpleOrder order) {
        super(account, channel, subject);
        super.setSubject(subject);
        this.order = order;
        super.addLanguage("en", "Dear %s your order with this serial number: %s has been shipped.");
    }
    public void assignPlaceholders(){
        String content = super.getContent();
        content = String.format(content, super.getReceiver().getName(), order.getSerialNumber());
        super.setContent(content);
    }
}
