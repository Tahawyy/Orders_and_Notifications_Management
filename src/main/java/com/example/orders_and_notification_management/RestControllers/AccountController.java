package com.example.orders_and_notification_management.RestControllers;

import com.example.orders_and_notification_management.Models.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.orders_and_notification_management.Services.AccountService;

@RestController
public class AccountController {
    @Autowired
    private AccountService accountService;

    @PostMapping("/signup")
    public ResponseEntity<Account> addAccount(@RequestBody Account account) {
       Boolean isAdded = accountService.addAccount(account);
       if(isAdded) {
           // 201 Created
           return ResponseEntity.status(201).body(account);
       }
         else {
              return ResponseEntity.status(409).body(account); // 409 Conflict
         }
    }



}
