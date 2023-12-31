package com.example.orders_and_notification_management.RestControllers;

import com.example.orders_and_notification_management.Models.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.orders_and_notification_management.Services.AccountService;

import java.util.ArrayList;

@RestController
public class AccountController {
    @Autowired
    private AccountService accountService;

    @PostMapping("/user/signup")
    public ResponseEntity<Account> addAccount(@RequestBody Account account) {
       Boolean isAdded = accountService.addAccount(account);
        if(isAdded) {
           // 201 Created
           return ResponseEntity.status(201).body(account);
        }
         else {
              return ResponseEntity.status(409).body(null); // 409 Conflict
         }
    }

    @GetMapping("/user/check")
    public ResponseEntity<Account> checkUser(@RequestParam String email , @RequestParam String password) {
    	Account acc = accountService.getAccount(email , password);
            if(acc != null) {
        		return ResponseEntity.status(200).body(acc); // 200 OK
        	}
        	else {
        		return ResponseEntity.status(404).body(null); // 404 Not Found
        	}
    }

    @GetMapping("/accounts")
    public ResponseEntity<ArrayList<Account>> getAccounts() {
    	return ResponseEntity.status(200).body(accountService.getAccounts()); // 200 OK
    }

}
