package com.example.orders_and_notification_management.Repositories;

import com.example.orders_and_notification_management.Models.Product;

import java.util.ArrayList;

public interface ProductsRepositry {
    public ArrayList<Product> getProducts();
    public void addProduct(Product product);
    public void removeProduct(Product product);
    public Product getProduct(String serialNumber);
    public void updateProduct(Product product);
}
