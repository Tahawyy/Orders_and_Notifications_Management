package com.example.orders_and_notification_management.Manager;

import com.example.orders_and_notification_management.Repositories.Orders;
import com.example.orders_and_notification_management.Services.AccountService;
import com.example.orders_and_notification_management.Services.NotificationService;
import com.example.orders_and_notification_management.Services.OrderService;
import com.example.orders_and_notification_management.Services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;

public abstract class OrderManager {
    protected OrderService orderService;
    protected AccountService accountService;
    protected NotificationService notificationService;

    public OrderManager(OrderService orderService, AccountService accountService, NotificationService notificationService) {
        this.orderService = orderService;
        this.accountService = accountService;
        this.notificationService = notificationService;
    }
    public abstract Boolean shipOrder(String SerialNumber);
    public abstract Boolean cancelPlacement(String SerialNumber);
    public abstract Boolean cancelShipping(String SerialNumber);
}
