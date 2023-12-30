package com.example.orders_and_notification_management.NotificationSystem;

import com.example.orders_and_notification_management.Models.Account;
import com.example.orders_and_notification_management.Models.SimpleOrder;

public class ShipmentNotification extends Notification{
    SimpleOrder order;
    String subject = "Your order has been shipped";
    public ShipmentNotification(Account account, NotificationChannel channel, SimpleOrder order) {
        super(account, channel);
        super.setSubject(subject);
        this.order = order;
        super.addLanguage("en", "Dear %name% your order with this serial number: %serialNumber% has been shipped.");
    }
    public void assignPlaceholders(){
        super.getContent().replace("%name%", super.getReceiver().getName());
        super.getContent().replace("%serialNumber%", String.valueOf(order.getSerialNumber()));
    }
}
