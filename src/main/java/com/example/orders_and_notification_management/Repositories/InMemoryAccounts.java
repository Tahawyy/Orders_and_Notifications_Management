package com.example.orders_and_notification_management.Repositories;

import java.util.ArrayList;
import com.example.orders_and_notification_management.Models.Account;
import org.springframework.stereotype.Repository;


@Repository
public class InMemoryAccounts implements Accounts {
    private ArrayList<Account> accounts;
    public InMemoryAccounts() {
        accounts = new ArrayList<Account>();
    }
    @Override
    public ArrayList<Account> getAccounts() {
        return accounts;
    }
    @Override
    public void addAccount(Account account) {
        accounts.add(account);
    }
    @Override
    public void removeAccount(Account account) {
        accounts.remove(account);
    }
    @Override
    public void updateAccount(Account account) {
        for (Account a : accounts) {
            if (a.getEmail().equals(account.getEmail())) {
                a.setPassword(account.getPassword());
                a.setBalance(account.getBalance());
            }
        }
    }
    @Override
    public Account getAccount(String email , String password) {
        for (Account a : accounts) {
            if (a.getEmail().equals(email) && a.getPassword().equals(password)) {
                return a;
            }
        }
        return null;
    }
    @Override
    public Account getAccount(String email){
        for (Account a : accounts) {
            if (a.getEmail().equals(email)) {
                return a;
            }
        }
        return null;
    }

}
