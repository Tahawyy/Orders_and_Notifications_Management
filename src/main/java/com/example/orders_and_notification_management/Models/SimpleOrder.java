package com.example.orders_and_notification_management.Models;

import com.example.orders_and_notification_management.Services.NotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.management.Notification;
import java.util.ArrayList;
@Component
public class SimpleOrder extends Order{
    ArrayList<Product> products;
    Account account;
    @Autowired
    NotificationService notificationService;
    @Override
    public Order printOrder() {
        return this;
    }
    public ArrayList<Product> getProducts() {
        return products;
    }

    public void setProducts(ArrayList<Product> products) {
        this.products = products;
    }

    public Account getAccount() {
        return account;
    }
    public void setAccount(Account account) {
        this.account = account;
    }
    public void shipped(NotificationService notificationService) {
        this.setStatus(OrderStatus.SHIPPED);
        account.setBalance(account.getBalance() - this.getShippingCost());
        notificationService.sendShipmentNotification(account, this);
    }
}
