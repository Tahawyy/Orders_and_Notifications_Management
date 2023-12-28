package com.example.orders_and_notification_management.RestControllers;

import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.orders_and_notification_management.Services.ProductService;
import com.example.orders_and_notification_management.Models.Product;

import java.util.ArrayList;

@RestController
public class ProductController {
    @Autowired
    private ProductService productService;

    @GetMapping("/products")
    public ResponseEntity<ArrayList<Product>> getAllProducts(){
        ArrayList<Product> products = productService.getProducts();
        return ResponseEntity.status(200).body(products); // 200 OK
    }

    @GetMapping("/product/get")
    public ResponseEntity<Product> getProductById(@RequestParam String serialNumber){
        Product product = productService.getProduct(serialNumber);
        if(product != null) {
            return ResponseEntity.status(200).body(product); // 200 OK
        }
        else {
            return ResponseEntity.status(404).body(product); // 404 Not Found
        }
    }

    @PostMapping("/product/add")
    public ResponseEntity<Product> addProduct(@RequestBody Product product){
        Boolean isAdded = productService.addProduct(product);
        if(isAdded) {
            // 201 Created
            return ResponseEntity.status(201).body(product);
        }
        else {
            return ResponseEntity.status(409).body(product); // 409 Conflict
        }

    }


}
