package com.example.orders_and_notification_management.Factories;

import com.example.orders_and_notification_management.Manager.OrderManager;
import com.example.orders_and_notification_management.Models.CompoundOrder;
import com.example.orders_and_notification_management.Models.Order;
import com.example.orders_and_notification_management.Models.SimpleOrder;
import com.example.orders_and_notification_management.Manager.CompoundOrderManager;
import com.example.orders_and_notification_management.Repositories.Orders;
import com.example.orders_and_notification_management.Services.AccountService;
import com.example.orders_and_notification_management.Services.NotificationService;
import com.example.orders_and_notification_management.Services.OrderService;
import com.example.orders_and_notification_management.Manager.SimpleOrderManager;
import com.example.orders_and_notification_management.Services.ProductService;


public class OrderManagerFactory implements IOrderManagerFactory {
    protected OrderService orderService;
    protected AccountService accountService;
    protected NotificationService notificationService;
    public OrderManagerFactory(OrderService orderService, AccountService accountService, NotificationService notificationService) {
        this.orderService = orderService;
        this.accountService = accountService;
        this.notificationService = notificationService;
    }
    public OrderManager createOrderManager(String serialNumber) {
        Order order = orderService.getOrder(serialNumber);
        if(order instanceof SimpleOrder){
            return new SimpleOrderManager(orderService, accountService, notificationService);
        }
        else if(order instanceof CompoundOrder){
            return new CompoundOrderManager(orderService,  accountService, notificationService);
        }
        return null;
    }
}
