package com.example.orders_and_notification_management.RestControllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.example.orders_and_notification_management.Services.ProductService;
import com.example.orders_and_notification_management.Models.Product;

import java.util.ArrayList;

@RestController
public class ProductController {
    @Autowired
    private ProductService productService;

    @GetMapping("/getProducts")
    public ResponseEntity<ArrayList<Product>> getAllProducts(){
        ArrayList<Product> products = productService.getProducts();
        return ResponseEntity.status(200).body(products); // 200 OK
    }

    @GetMapping("/getProduct")
    public ResponseEntity<Product> getProductById(@RequestParam String serialNumber){
        Product product = productService.getProduct(serialNumber);
        if(product != null) {
            return ResponseEntity.status(200).body(product); // 200 OK
        }
        else {
            return ResponseEntity.status(404).body(product); // 404 Not Found
        }
    }


}
