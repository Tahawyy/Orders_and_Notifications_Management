package com.example.orders_and_notification_management.Services;


import com.example.orders_and_notification_management.Factories.IOrderFactory;
import com.example.orders_and_notification_management.Factories.OrderFactory;
import com.example.orders_and_notification_management.Models.*;
import com.example.orders_and_notification_management.Repositories.Orders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;

@Service
public class OrderService {
    @Autowired
    private Orders orders;

    @Autowired
    private ProductService productService;

    @Autowired
    private AccountService accountService;
    @Autowired
    private NotificationService notificationService;

    public ArrayList<Order> getOrders() {
        return orders.getOrders();
    }

    public Boolean placeOrder(Order order) {
        IOrderFactory orderFactory = new OrderFactory(productService, accountService, notificationService);
        if(orders.getOrder(order.getSerialNumber()) == null) {
            order = orderFactory.createOrder(order);
            orders.addOrder(order);
            return true;
        }
        return false;
    }

    public Boolean shipOrder(String SerialNumber) {
        Order order = orders.getOrder(SerialNumber);
        if(order != null && order.getStatus() == OrderStatus.PLACED) {
            order.shipped(notificationService);
            return true;
        }
        return false;
    }
    public Boolean cancelPlacement(String SerialNumber) {
        Order order = orders.getOrder(SerialNumber);
        if(order != null && order.getPlacementCancelDeadline().isAfter(LocalDateTime.now())) {
            order.setStatus(OrderStatus.CANCELLED);
            // TODO : return money to account
            order.cancelPlacement();
            return true;
        }
        return false;
    }
    public Boolean cancelShipping(String SerialNumber) {
        Order order = orders.getOrder(SerialNumber);
        if(order != null && order.getStatus() == OrderStatus.SHIPPED && order.getShippingCancelDeadline().isAfter(LocalDateTime.now())) {
            order.setStatus(OrderStatus.PLACED);
            // TODO : return money to account
            order.cancelShipping();
            return true;
        }
        return false;
    }
    public Order getOrder(String serialNumber) {
        return orders.getOrder(serialNumber);
    }
}
