package com.example.orders_and_notification_management.RestControllers;


import org.apache.coyote.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.orders_and_notification_management.Services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import com.example.orders_and_notification_management.Models.Category;

import java.util.ArrayList;

@RestController
public class CategoriesController {
    @Autowired
    private CategoryService categoryService;

    @PostMapping("/category/add")
    public ResponseEntity<Category> addCategory(@RequestBody Category category) {
       Boolean isAdded = categoryService.addCategory(category);
       if(isAdded) {
           // 201 Created
           return ResponseEntity.status(201).body(category);
       }
         else {
              return ResponseEntity.status(409).body(category); // 409 Conflict
         }
    }
    @GetMapping("/category/remainingQuantity")
    public ResponseEntity<Integer> getRemainingQuantity(@RequestParam String name) {
        int remainingQuantity = categoryService.getRemainingQuantity(name);
        if(remainingQuantity == -1){
            return ResponseEntity.status(404).body(remainingQuantity); // 404 Not Found
        }
        else {
            return ResponseEntity.status(200).body(remainingQuantity); // 200 OK
        }
    }
    @GetMapping("/categories")
    public ResponseEntity<ArrayList<Category>> getCategories() {
        return ResponseEntity.status(200).body(categoryService.getCategories()); // 200 OK
    }


}
