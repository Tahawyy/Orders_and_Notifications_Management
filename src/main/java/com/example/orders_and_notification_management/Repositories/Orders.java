package com.example.orders_and_notification_management.Repositories;

import com.example.orders_and_notification_management.Models.Order;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
@Repository
public class Orders {
    private ArrayList<Order> orders;

    public Orders() {
        orders = new ArrayList<>();
    }

    public ArrayList<Order> getOrders() {
        return orders;
    }

    public void addOrder(Order order) {

        orders.add(order);
    }

    public void removeOrder(Order order) {
        orders.remove(order);
    }
    public void updateOrder(Order order) {
        for (Order o : orders) {
            if (o.equals(order)) {
                o = order;
            }
        }
    }
    public Order getOrder(String serialNumber) {
        for (Order o : orders) {
            if (o.getSerialNumber().equals(serialNumber)) {
                return o;
            }
        }
        return null;
    }
}
