package com.example.orders_and_notification_management.Models;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
@Component
public class SimpleOrder extends Order{
    ArrayList<Product> products;
    Account account;
    @Override
    public Order printOrder() {
        return this;
    }
    public ArrayList<Product> getProducts() {
        return products;
    }

    public void setProducts(ArrayList<Product> products) {
        this.products = products;
    }

    public Account getAccount() {
        return account;
    }
    public void setAccount(Account account) {
        this.account = account;
    }
}
