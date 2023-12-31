package com.example.orders_and_notification_management.NotificationSystem;

import com.example.orders_and_notification_management.Models.Account;
import com.example.orders_and_notification_management.Models.Order;
import com.example.orders_and_notification_management.Models.Product;
import com.example.orders_and_notification_management.Models.SimpleOrder;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class PlacementNotification extends Notification {
    private SimpleOrder order;
    private static String subject = "Your order has been placed";

    public PlacementNotification(Account receiver, NotificationChannel channel, SimpleOrder order) {
        super(receiver, channel, subject);
        this.order = order;
        super.addLanguage("en", "Dear %s, your order of this products: %s has been placed. The total price is: %s, you can ship your order using this serial number: %s");
    }
    public void assignPlaceholders(){
        String content = super.getContent();
        String products = "";
        ArrayList<Product> productsList = order.getProducts();
        for(Product product : productsList)
            products += product.getProductName() + ", ";
        products = products.substring(0, products.length() - 2);
        content = String.format(content, super.getReceiver().getName(), products, order.getTotalPrice(), order.getSerialNumber());
        super.setContent(content);
    }
}
