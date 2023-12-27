package com.example.orders_and_notification_management.Models;

public class Account {
    private String email;  // The email of the account
    private String password; // The password of the account
    private double balance; // The balance of the account
    public Account(String email, String password, double balance) {
        this.email = email;
        this.password = password;
        this.balance = balance;
    }
    public String getEmail() {
        return email;
    }
    public String getPassword() {
        return password;
    }
    public double getBalance() {
        return balance;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public void setBalance(double balance) {
        this.balance = balance;
    }
}
