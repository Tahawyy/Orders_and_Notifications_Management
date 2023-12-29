package com.example.orders_and_notification_management.Models;

import org.springframework.stereotype.Component;

@Component
public abstract class Order {
    private String serialNumber;
    private Address address;
    private double shippingCost;
    OrderStatus status;

    public OrderStatus getStatus() {
        return status;
    }
    public void setStatus(OrderStatus status) {
        this.status = status;
    }
    public abstract Order printOrder();
    public String getSerialNumber() {
        return serialNumber;
    }
    public Address getAddress() {
        return address;
    }
    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }
    public void setAddress(Address address) {
        this.address = address;
    }

    public double getShippingCost() {
        return shippingCost;
    }

    public void setShippingCost(double shippingCost) {
        this.shippingCost = shippingCost;
    }
}
