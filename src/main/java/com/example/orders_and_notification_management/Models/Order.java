package com.example.orders_and_notification_management.Models;


import com.example.orders_and_notification_management.Services.NotificationService;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

import java.time.LocalDateTime;

@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, property = "orderType")
@JsonSubTypes({
        @JsonSubTypes.Type(value = SimpleOrder.class, name = "SimpleOrder"),
        @JsonSubTypes.Type(value = CompoundOrder.class, name = "CompoundOrder")
})
public abstract class Order {
    private String serialNumber;
    private Address address;
    private double shippingCost;
    private OrderStatus status;

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
    public abstract void cancelPlacement();
    public abstract void cancelShipping();

}
