package com.example.orders_and_notification_management.Models;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
@Component
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
}
