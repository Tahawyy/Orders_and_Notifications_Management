package com.example.orders_and_notification_management.Models;

public class Product {
    private String serialNumber; // The serial number of the product
    private String productName;
    private Category category;
    private String vendor;
    private double price;
    public Product(String serialNumber, String productName, Category category, String vendor, double price) {
        this.serialNumber = serialNumber;
        this.productName = productName;
        this.category = category;
        this.vendor = vendor;
        this.price = price;
    }
    public String getSerialNumber() {
        return serialNumber;
    }
    public String getProductName() {
        return productName;
    }
    public Category getCategory() {
        return category;
    }
    public String getVendor() {
        return vendor;
    }
    public double getPrice() {
        return price;
    }
    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }
    public void setProductName(String productName) {
        this.productName = productName;
    }
    public void setCategory(Category category) {
        this.category = category;
    }
    public void setVendor(String vendor) {
        this.vendor = vendor;
    }
    public void setPrice(double price) {
        this.price = price;
    }


}
