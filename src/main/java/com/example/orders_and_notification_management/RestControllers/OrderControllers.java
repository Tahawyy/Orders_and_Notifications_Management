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

    @PostMapping("/order/addSimpleOrder")
    public ResponseEntity<Order> placeOrder(@RequestBody SimpleOrder order) {
        if(!orderService.placeOrder(order)){
            return ResponseEntity.status(409).body(null);
        }
        return ResponseEntity.status(201).body(order);
    }
    @PostMapping("/order/addCompoundOrder")
    public ResponseEntity<Order> placeOrder(@RequestBody CompoundOrder order) {
        if(!orderService.placeOrder(order)){
            return ResponseEntity.status(409).body(null);
        }
        return ResponseEntity.status(201).body(order);
    }
    @GetMapping("/order/{serialNumber}")
    public ResponseEntity<Order> getOrder(@PathVariable("serialNumber") String serialNumber) {
        Order order = orderService.getOrder(serialNumber);
        if(order == null) {
            return ResponseEntity.status(404).body(null);
        }
        return ResponseEntity.status(201).body(order);
    }
    @GetMapping("/order/{serialNumber}/cancelPlacement")
    public ResponseEntity<Boolean> cancelPlacement(@PathVariable("serialNumber") String serialNumber) {
        return ResponseEntity.status(201).body(orderService.cancelPlacement(serialNumber));
    }
    @GetMapping("/order/{serialNumber}/cancelShipping")
    public ResponseEntity<Boolean> cancelShipping(@PathVariable("serialNumber") String serialNumber) {
        return ResponseEntity.status(201).body(orderService.cancelShipping(serialNumber));
    }
    @GetMapping("/order/{serialNumber}/ship")
    public ResponseEntity<Boolean> ship(@PathVariable("serialNumber") String serialNumber) {
        return ResponseEntity.status(201).body(orderService.shipOrder(serialNumber));
    }
//    @GetMapping("/order/{serialNumber}/shipCompoundOrder")
//    public ResponseEntity<Boolean> shipCompoundOrder(@PathVariable("serialNumber") String serialNumber) {
//        return ResponseEntity.status(201).body(orderService.shipCompoundOrder(serialNumber));
//    }
//    @GetMapping("/order/{serialNumber}/shipSimpleOrder")
//    public ResponseEntity<Boolean> shipSimpleOrder(@PathVariable("serialNumber") String serialNumber) {
//        return ResponseEntity.status(201).body(orderService.shipSimpleOrder(serialNumber));
//    }
}