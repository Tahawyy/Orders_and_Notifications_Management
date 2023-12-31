package com.example.orders_and_notification_management.Repositories;

import com.example.orders_and_notification_management.Models.Order;

import java.util.ArrayList;

public interface OrdersRepositry {
    public ArrayList<Order> getOrders();
    public void addOrder(Order order);
    public void removeOrder(Order order);
    public void updateOrder(Order order);
    public Order getOrder(String serialNumber);
}
