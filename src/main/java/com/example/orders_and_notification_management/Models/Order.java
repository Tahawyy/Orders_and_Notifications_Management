package com.example.orders_and_notification_management.Models;


import com.example.orders_and_notification_management.Services.NotificationService;

import java.time.LocalDateTime;

public abstract class Order {
    private String serialNumber;
    private Address address;
    private double shippingCost;
    OrderStatus status;

    LocalDateTime placementCancelDeadline;
    LocalDateTime shippingCancelDeadline;
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

    public LocalDateTime getPlacementCancelDeadline() {
        return placementCancelDeadline;
    }

    public void setPlacementCancelDeadline(LocalDateTime placementCancelDeadline) {
        this.placementCancelDeadline = placementCancelDeadline;
    }

    public LocalDateTime getShippingCancelDeadline() {
        return shippingCancelDeadline;
    }

    public void setShippingCancelDeadline(LocalDateTime shippingCancelDeadline) {
        this.shippingCancelDeadline = shippingCancelDeadline;
    }

    public void setShippingCost(double shippingCost) {
        this.shippingCost = shippingCost;
    }
    public abstract void shipped(NotificationService notificationService);
}
