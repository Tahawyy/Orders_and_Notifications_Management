package com.example.orders_and_notification_management.Models;

import org.springframework.stereotype.Component;

@Component
public abstract class Order {
    private String serialNumber;
    private Address address;
    private String type;
    public abstract Order printOrder();
    public String getSerialNumber() {
        return serialNumber;
    }
    public Address getAddress() {
        return address;
    }
    public void setSerialNumber(String serialNumber) {
        serialNumber = serialNumber;
    }
    public void setAddress(Address address) {
        this.address = address;
    }
}
