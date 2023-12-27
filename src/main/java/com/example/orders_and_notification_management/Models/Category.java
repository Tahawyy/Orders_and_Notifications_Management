package com.example.orders_and_notification_management.Models;

public class Category {
    private String name;
    private int remainingQuantity; // remaining quantity of products in this category
    public Category(String name, int remainingQuantity) {
        this.name = name;
        this.remainingQuantity = remainingQuantity;
    }
    public String getName() {
        return name;
    }
    public int getRemainingQuantity() {
        return remainingQuantity;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setRemainingQuantity(int remainingQuantity) {
        this.remainingQuantity = remainingQuantity;
    }
}
