package com.example.orders_and_notification_management.Models;

import com.example.orders_and_notification_management.Services.NotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.management.Notification;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;

@Component
public class SimpleOrder extends Order{
    ArrayList<Product> products;
    Account account;
    double price;
    @Override
    public Order printOrder() {
        return this;
    }
    public ArrayList<Product> getProducts() {
        return products;
    }
    public double getTotalPrice() {
        return price;
    }
    public void setTotalPrice(double price) {
        this.price = price;
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
        super.setShippingCancelDeadline(LocalDateTime.now().plusMinutes(5));
    }
    public void cancelPlacement() {
        this.setStatus(OrderStatus.CANCELLED);
        account.setBalance(account.getBalance() + this.getTotalPrice());
    }
    public void cancelShipping() {
        this.setStatus(OrderStatus.PLACED);
        account.setBalance(account.getBalance() + this.getShippingCost());
    }
}
