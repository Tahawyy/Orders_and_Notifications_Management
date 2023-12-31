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
    protected Orders orders;
    protected ProductService productService;
    protected AccountService accountService;
    protected NotificationService notificationService;
    public OrderManagerFactory(Orders orders, ProductService productService, AccountService accountService, NotificationService notificationService) {
        this.orders = orders;
        this.productService = productService;
        this.accountService = accountService;
        this.notificationService = notificationService;
    }
    public OrderManager createOrderService(String serialNumber) {
        Order order = OrderService.getOrder(serialNumber);
        if(order instanceof SimpleOrder){
            return new SimpleOrderManager(orders, productService, accountService, notificationService);
        }
        else if(order instanceof CompoundOrder){
            return new CompoundOrderManager(orders, productService, accountService, notificationService);
        }
        return null;
    }
}
