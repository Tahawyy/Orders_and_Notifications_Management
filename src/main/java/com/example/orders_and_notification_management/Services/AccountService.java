package com.example.orders_and_notification_management.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.orders_and_notification_management.Repositories.Accounts;
import com.example.orders_and_notification_management.Models.Account;

import java.util.ArrayList;

@Service
public class AccountService {
    @Autowired
    private Accounts accounts;
    public ArrayList<Account> getAccounts() {
        return accounts.getAccounts();
    }
    public Boolean addAccount(Account account) {
       if(accounts.getAccount(account.getEmail() , account.getPassword()) == null) {
           accounts.addAccount(account);
           return true;
       }
       return false;
    }
    public void deduceBalance(double amount , Account account) {
        account.setBalance(account.getBalance() - amount);
    }
    public boolean removeAccount(Account account)
    {
        if(accounts.getAccount(account.getEmail() , account.getPassword()) != null) {
            accounts.removeAccount(account);
            return true;
        }
        return false;
    }
    public boolean UpdateAccount(Account account) {
        if(accounts.getAccount(account.getEmail() , account.getPassword()) != null) {
            accounts.updateAccount(account);
            return true;
        }
        return false;
    }
    public Account getaccount(String email , String password) {
        return accounts.getAccount(email , password);
    }
}
