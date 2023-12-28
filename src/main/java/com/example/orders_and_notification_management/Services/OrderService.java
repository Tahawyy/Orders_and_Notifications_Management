package com.example.orders_and_notification_management.Services;


import com.example.orders_and_notification_management.Models.Order;
import com.example.orders_and_notification_management.Repositories.Orders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class OrderService {
    @Autowired
    private Orders orders;

    public ArrayList<Order> getOrders() {
        return orders.getOrders();
    }
    public Boolean addOrder(Order order) {
        if(orders.getOrder(order.getSerialNumber()) == null) {
            orders.addOrder(order);
            return true;
        }
        return false;
    }
    public Order getOrder(String serialNumber) {
        return orders.getOrder(serialNumber);
    }
}
