package com.example.orders_and_notification_management.Manager;

import com.example.orders_and_notification_management.Models.OrderStatus;
import com.example.orders_and_notification_management.Models.SimpleOrder;
import com.example.orders_and_notification_management.Repositories.Orders;
import com.example.orders_and_notification_management.Services.AccountService;
import com.example.orders_and_notification_management.Services.NotificationService;
import com.example.orders_and_notification_management.Services.OrderService;
import com.example.orders_and_notification_management.Services.ProductService;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
@Component
public class SimpleOrderManager extends OrderManager {
    public SimpleOrderManager(Orders orders, ProductService productService, AccountService accountService, NotificationService notificationService) {
        super(orders, productService, accountService, notificationService);
    }

    @Override
    public Boolean shipOrder(String SerialNumber) {
        SimpleOrder order =(SimpleOrder) orders.getOrder(SerialNumber);
        if(order != null && order.getStatus() == OrderStatus.PLACED) {
            order.setStatus(OrderStatus.SHIPPED);
            order.getAccount().setBalance(order.getAccount().getBalance() - order.getShippingCost());
            notificationService.sendShipmentNotification(order.getAccount(), order);
            order.setShippingCancelDeadline(LocalDateTime.now().plusMinutes(5));
            return true;
        }
        return false;
    }

    @Override
    public Boolean cancelPlacement(String SerialNumber) {
        SimpleOrder order =(SimpleOrder) orders.getOrder(SerialNumber);
        if(order != null && order.getPlacementCancelDeadline().isAfter(LocalDateTime.now())) {
            order.setStatus(OrderStatus.CANCELLED);
            order.getAccount().setBalance(order.getAccount().getBalance() + order.getTotalPrice());
            return true;
        }
        return false;
    }

    public Boolean cancelShipping(String SerialNumber) {
        SimpleOrder order =(SimpleOrder)  orders.getOrder(SerialNumber);
        if(order != null && order.getStatus() == OrderStatus.SHIPPED && order.getShippingCancelDeadline().isAfter(LocalDateTime.now())) {
            order.setStatus(OrderStatus.PLACED);
            order.getAccount().setBalance( order.getAccount().getBalance() + order.getShippingCost());
            return true;
        }
        return false;
    }
}
