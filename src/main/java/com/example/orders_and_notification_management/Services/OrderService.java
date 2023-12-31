package com.example.orders_and_notification_management.Services;


import com.example.orders_and_notification_management.Models.*;
import com.example.orders_and_notification_management.Repositories.Orders;
import com.fasterxml.jackson.databind.deser.std.DateDeserializers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;

@Service
public class OrderService {
    @Autowired
    private Orders orders;

    @Autowired
    private ProductService productService;

    @Autowired
    private AccountService accountService;
    @Autowired
    private NotificationService notificationService;

    public ArrayList<Order> getOrders() {
        return orders.getOrders();
    }
    public SimpleOrder setOrder(SimpleOrder order){
        ArrayList<Product> products = new ArrayList<>();
        for (Product p : order.getProducts()) {
            Product pr = productService.getProduct(p.getSerialNumber());
            products.add(pr);
            pr.getCategory().setRemainingQuantity(pr.getCategory().getRemainingQuantity()-1);
            pr.setQuantity(pr.getQuantity()-1);

        }
        double total = 0;
        for (Product p : products) {
            total += p.getPrice();
        }

        order.setProducts(products);
        order.setAccount(accountService.getAccount(order.getAccount().getEmail(), order.getAccount().getPassword()));
        if(total > order.getAccount().getBalance()) {
            return null;
        }
        accountService.deduceBalance(total, order.getAccount());
        order.setStatus(OrderStatus.PLACED);
        order.setPlacementCancelDeadline(LocalDateTime.now().plusMinutes(1));
        return order;
    }
    public CompoundOrder setOrder(CompoundOrder order){
        ArrayList<SimpleOrder> orders = new ArrayList<>();
        for (SimpleOrder o : order.getOrders()) {
            SimpleOrder nwOrder = setOrder(o);
            if(nwOrder == null) {
                return null;
            }
            nwOrder.setShippingCost(order.getShippingCost() / order.getOrders().size());
            orders.add(nwOrder);
        }
        order.setOrders(orders);
        order.setStatus(OrderStatus.PLACED);
        order.setPlacementCancelDeadline(LocalDateTime.now().plusMinutes(1));
        return order;
    }
    public Boolean placeOrder(SimpleOrder order) {
        order = setOrder(order);
        if(orders.getOrder(order.getSerialNumber()) == null) {
            orders.addOrder(order);
            notificationService.sendPlacementNotification(order.getAccount(), order);
            return true;
        }
        return false;
    }
    public Boolean placeOrder(CompoundOrder order) {
        order = setOrder(order);
        if(orders.getOrder(order.getSerialNumber()) == null) {
            orders.addOrder(order);
            return true;
        }
        return false;
    }

    public Boolean shipOrder(String SerialNumber) {
        Order order = orders.getOrder(SerialNumber);
        if(order != null && order.getStatus() == OrderStatus.PLACED) {
            order.shipped(notificationService);
            return true;
        }
        return false;
    }
    public Boolean cancelPlacement(String SerialNumber) {
        Order order = orders.getOrder(SerialNumber);
        if(order != null && order.getPlacementCancelDeadline().isAfter(LocalDateTime.now())) {
            order.setStatus(OrderStatus.CANCELLED);
            // TODO : return money to account
            return true;
        }
        return false;
    }
    public Boolean cancelShipping(String SerialNumber) {
        Order order = orders.getOrder(SerialNumber);
        if(order != null && order.getStatus() == OrderStatus.SHIPPED && order.getShippingCancelDeadline().isAfter(LocalDateTime.now())) {
            order.setStatus(OrderStatus.PLACED);
            // TODO : return money to account
            return true;
        }
        return false;
    }
    public Order getOrder(String serialNumber) {
        return orders.getOrder(serialNumber);
    }
}
