package com.example.orders_and_notification_management.RestControllers;

import com.example.orders_and_notification_management.Models.CompoundOrder;
import com.example.orders_and_notification_management.Models.Order;
import com.example.orders_and_notification_management.Models.SimpleOrder;
import com.example.orders_and_notification_management.Services.OrderService;
import org.springframework.http.HttpRequest;
import org.springframework.http.HttpStatus;
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
    public Order placeOrder(@RequestBody SimpleOrder order) {
        if(!orderService.placeOrder(order)){
            HttpStatus status = HttpStatus.CONFLICT;
            return null;
        }
        return order;
    }
    @PostMapping("/order/addCompoundOrder")
    public Order placeOrder(@RequestBody CompoundOrder order) {
        orderService.placeOrder(order);
        return order;
    }
    @GetMapping("/order/{serialNumber}")
    public Order getOrder(@PathVariable("serialNumber") String serialNumber) {
        return  orderService.getOrder(serialNumber);
    }

    @GetMapping("/order/{serialNumber}/ship")
    public Boolean ship(@PathVariable("serialNumber") String serialNumber) {
        return orderService.shipOrder(serialNumber);
    }
}
