package com.example.orders_and_notification_management.Services;


import com.example.orders_and_notification_management.Models.*;
import com.example.orders_and_notification_management.Repositories.Orders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class OrderService {
    @Autowired
    private Orders orders;

    @Autowired
    private ProductService productService;

    @Autowired
    private AccountService accountService;

    public ArrayList<Order> getOrders() {
        return orders.getOrders();
    }
    public SimpleOrder setOrder(SimpleOrder order){
        ArrayList<Product> products = new ArrayList<>();
        for (Product p : order.getProducts()) {
            products.add(productService.getProduct(p.getSerialNumber()));
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
            orders.add(setOrder(o));
        }
        order.setOrders(orders);
        return order;
    }
    public Boolean placeOrder(SimpleOrder order) {
        order = setOrder(order);
        if(orders.getOrder(order.getSerialNumber()) == null) {
            orders.addOrder(order);
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
        if(order != null) {
            order.setStatus(OrderStatus.SHIPPED);
            return true;
        }
        return false;
    }
    public Order getOrder(String serialNumber) {
        return orders.getOrder(serialNumber);
    }
}
