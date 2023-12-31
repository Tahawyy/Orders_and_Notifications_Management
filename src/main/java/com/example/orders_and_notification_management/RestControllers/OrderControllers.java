package com.example.orders_and_notification_management.RestControllers;

import com.example.orders_and_notification_management.Models.CompoundOrder;
import com.example.orders_and_notification_management.Models.Order;
import com.example.orders_and_notification_management.Models.SimpleOrder;
import com.example.orders_and_notification_management.Services.OrderService;
import org.springframework.http.HttpRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class OrderControllers {
    private OrderService orderService;

    public OrderControllers(OrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping("/order/addOrder")
    public ResponseEntity<Order> placeOrder(@RequestBody Order order) {
        if(!orderService.placeOrder(order)){
            return ResponseEntity.status(409).body(null);
        }
        return ResponseEntity.status(201).body(order);
    }
    @GetMapping("/order/get")
    public ResponseEntity<Order> getOrder(@RequestParam String serialNumber) {
        Order order = orderService.getOrder(serialNumber);
        if(order == null) {
            return ResponseEntity.status(404).body(null);
        }
        return ResponseEntity.status(201).body(order);
    }

    @GetMapping("/order/cancelPlacement")
    public ResponseEntity<Boolean> cancelPlacement(@RequestParam String serialNumber) {
        boolean result = orderService.cancelPlacement(serialNumber);
        if(!result){
            return ResponseEntity.status(409).body(false);
        }
        return ResponseEntity.status(200).body(result);
    }
    @GetMapping("/order/cancelShipping")
    public ResponseEntity<Boolean> cancelShipping(@RequestParam String serialNumber) {
        boolean result = orderService.cancelShipping(serialNumber);
        if(!result){
            return ResponseEntity.status(409).body(false);
        }
        return ResponseEntity.status(200).body(result);
    }
    @GetMapping("/order/ship")
    public ResponseEntity<Boolean> ship(@RequestParam String serialNumber) {
        boolean result = orderService.shipOrder(serialNumber);
        if(!result){
            return ResponseEntity.status(409).body(false);
        }
        return ResponseEntity.status(200).body(result);
    }
}