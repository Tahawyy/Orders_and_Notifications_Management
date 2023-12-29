package com.example.orders_and_notification_management.Models;



import java.util.ArrayList;
import java.util.List;
public class CompoundOrder extends Order {

    private List<SimpleOrder> orders;
    public CompoundOrder() {
        orders = new ArrayList<>();
    }
    @Override
    public Order printOrder() {
        return this;
    }
    public List<SimpleOrder> getOrders() {
        return orders;
    }

    public void setOrders(List<SimpleOrder> orders) {
        this.orders = orders;
    }

    public void shipped() {
        this.setStatus(OrderStatus.SHIPPED);
        for (SimpleOrder o : orders) {
            o.shipped();
        }
    }
}