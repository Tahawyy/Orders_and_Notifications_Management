package com.example.orders_and_notification_management.Repositories;

import com.example.orders_and_notification_management.Models.Account;

import java.util.ArrayList;

public interface AccountsRepositry {
    public ArrayList<Account> getAccounts();
    public void addAccount(Account account);
    public void removeAccount(Account account);
    public void updateAccount(Account account);
    public Account getAccount(String email , String password);
    public Account getAccount(String email);
}
