package com.example.orders_and_notification_management.Manager;

import com.example.orders_and_notification_management.Models.CompoundOrder;
import com.example.orders_and_notification_management.Models.OrderStatus;
import com.example.orders_and_notification_management.Models.SimpleOrder;
import com.example.orders_and_notification_management.Repositories.Orders;
import com.example.orders_and_notification_management.Services.AccountService;
import com.example.orders_and_notification_management.Services.NotificationService;
import com.example.orders_and_notification_management.Services.ProductService;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

public class CompoundOrderManager extends OrderManager {


    public CompoundOrderManager(Orders orders, ProductService productService, AccountService accountService, NotificationService notificationService) {
        super(orders, productService, accountService, notificationService);
    }

    @Override
    public Boolean shipOrder(String SerialNumber) {
        CompoundOrder order =(CompoundOrder) orders.getOrder(SerialNumber);
        if(order != null && order.getStatus() == OrderStatus.PLACED) {
            order.setStatus(OrderStatus.SHIPPED);
            for (SimpleOrder o : order.getOrders()) {
                o.setStatus(OrderStatus.SHIPPED);
                o.getAccount().setBalance(o.getAccount().getBalance() - o.getShippingCost());
                notificationService.sendShipmentNotification(o.getAccount(), o);
                o.setShippingCancelDeadline(LocalDateTime.now().plusMinutes(5));
            }
            return true;
        }
        return false;
    }

    @Override
    public Boolean cancelPlacement(String SerialNumber) {
        CompoundOrder order =(CompoundOrder) orders.getOrder(SerialNumber);
        if(order != null && order.getPlacementCancelDeadline().isAfter(LocalDateTime.now())) {
            order.setStatus(OrderStatus.CANCELLED);
            // TODO : return money to account
            for(SimpleOrder o : order.getOrders()) {
                o.setStatus(OrderStatus.CANCELLED);
                o.getAccount().setBalance(o.getAccount().getBalance() + o.getTotalPrice());
            }
            return true;
        }
        return false;
    }
    @Override
    public Boolean cancelShipping(String SerialNumber) {
        CompoundOrder order =(CompoundOrder) orders.getOrder(SerialNumber);
        if(order != null && order.getStatus() == OrderStatus.SHIPPED && order.getShippingCancelDeadline().isAfter(LocalDateTime.now())) {
            order.setStatus(OrderStatus.PLACED);
            // TODO : return money to account
            for(SimpleOrder o : order.getOrders()) {
                o.setStatus(OrderStatus.PLACED);
                o.getAccount().setBalance(o.getAccount().getBalance() + o.getShippingCost());
            }
            return true;
        }
        return false;
    }
}
