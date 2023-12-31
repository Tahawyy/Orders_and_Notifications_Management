package com.example.orders_and_notification_management.Repositories;

import com.example.orders_and_notification_management.Models.Order;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
@Repository
public class InMemoryOrders implements Orders {
    private ArrayList<Order> orders;

    public InMemoryOrders() {
        orders = new ArrayList<>();
    }
    @Override
    public ArrayList<Order> getOrders() {
        return orders;
    }
    @Override
    public void addOrder(Order order) {

        orders.add(order);
    }
    @Override
    public void removeOrder(Order order) {
        orders.remove(order);
    }
    @Override
    public void updateOrder(Order order) {
        for (Order o : orders) {
            if (o.equals(order)) {
                o = order;
            }
        }
    }
    @Override
    public Order getOrder(String serialNumber) {
        for (Order o : orders) {
            if (o.getSerialNumber().equals(serialNumber)) {
                return o;
            }
        }
        return null;
    }
}
