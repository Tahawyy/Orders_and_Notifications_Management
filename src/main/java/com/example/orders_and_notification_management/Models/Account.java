package com.example.orders_and_notification_management.Models;

public class Account {
    private String name; // The name of the account holder
    private String email;  // The email of the account
    private String password; // The password of the account
    private double balance; // The balance of the account

    private String phoneNumber; // The phone number of the account

    private String prefferedLanguage; // The preffered language of the account

    private String prefferedChannel; // The preffered channel of the account
    public Account(String name, String email, String password, double balance, String prefferedLanguage, String prefferedChannel, String phoneNumber) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.balance = balance;
        this.prefferedLanguage = prefferedLanguage;
        this.phoneNumber = phoneNumber;
        this.prefferedChannel = prefferedChannel;
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
    public String getName() {
        return name;
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
    public void setName(String name) {
        this.name = name;
    }
    public String getPrefferedLanguage() {
        return prefferedLanguage;
    }
    public void setPrefferedLanguage(String prefferedLanguage) {
        this.prefferedLanguage = prefferedLanguage;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getPrefferedChannel() {
        return prefferedChannel;
    }

    public void setPrefferedChannel(String prefferedChannel) {
        this.prefferedChannel = prefferedChannel;
    }
}
