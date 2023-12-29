package com.example.orders_and_notification_management.Models;

import java.util.ArrayList;

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
    public void shipped() {
        this.setStatus(OrderStatus.SHIPPED);
        account.setBalance(account.getBalance() - this.getShippingCost());
    }
}
