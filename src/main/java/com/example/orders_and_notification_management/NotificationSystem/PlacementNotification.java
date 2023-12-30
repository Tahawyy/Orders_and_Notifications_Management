package com.example.orders_and_notification_management.NotificationSystem;

import com.example.orders_and_notification_management.Models.Account;
import com.example.orders_and_notification_management.Models.Order;
import com.example.orders_and_notification_management.Models.SimpleOrder;

public class PlacementNotification extends Notification {
    public PlacementNotification(Account receiver, NotificationChannel channel, SimpleOrder order) {
        super();
        String subject = "Your order has been placed";
        String content = "Dear " + receiver.getName() + ", " +
                "Your order of the following: ";
        for (int i = 0; i < order.getProducts().size(); i++) {
            content += order.getProducts().get(i).getProductName() + ", ";
        }
        content += "has been placed. You can track your order with the following order number: " + order.getSerialNumber() + ". " +
                "Thank you for choosing us.";
        super.setReceiver(receiver);
        super.setSubject(subject);
        super.setContent(content);
        super.setChannel(channel);
    }
}
