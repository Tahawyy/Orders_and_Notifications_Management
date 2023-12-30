package com.example.orders_and_notification_management.NotificationSystem;

import com.example.orders_and_notification_management.Models.Account;
import com.example.orders_and_notification_management.Models.Order;
import com.example.orders_and_notification_management.Models.SimpleOrder;

import java.util.HashMap;
import java.util.Map;

public class PlacementNotification extends Notification {
    private SimpleOrder order;
    private String subject = "Your order has been placed";

    public PlacementNotification(Account receiver, NotificationChannel channel, SimpleOrder order) {
        super(receiver, channel);
        super.setSubject(subject);
        this.order = order;
        super.addLanguage("en", "Dear %name%, your order of this products: %products% has been placed. The total price is: %price%, you can ship your order using this serial number: %serialNumber%");
    }
    public void assignPlaceholders(){
        super.getContent().replace("%name%", super.getReceiver().getName());
        super.getContent().replace("%products%", order.getProducts().toString());
        super.getContent().replace("%price%", String.valueOf(order.getTotalPrice()));
        super.getContent().replace("%serialNumber%", String.valueOf(order.getSerialNumber()));
    }
}
