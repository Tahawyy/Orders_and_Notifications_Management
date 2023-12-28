package com.example.orders_and_notification_management.RestControllers;

import com.example.orders_and_notification_management.Models.CompoundOrder;
import com.example.orders_and_notification_management.Models.Order;
import com.example.orders_and_notification_management.Models.SimpleOrder;
import com.example.orders_and_notification_management.Services.OrderService;
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
    public void addOrder(@RequestBody SimpleOrder order) {
        orderService.addOrder(order);
    }
    @PostMapping("/order/addCompoundOrder")
    public void addOrder(@RequestBody CompoundOrder order) {
        orderService.addOrder(order);
    }
    @GetMapping("/order/{serialNumber}")
    public Order getOrder(@PathVariable("serialNumber") String serialNumber) {
        return  orderService.getOrder(serialNumber);
    }
}
