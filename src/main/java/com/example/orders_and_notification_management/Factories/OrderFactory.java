package com.example.orders_and_notification_management.Factories;

import com.example.orders_and_notification_management.Models.*;
import com.example.orders_and_notification_management.Services.AccountService;
import com.example.orders_and_notification_management.Services.NotificationService;
import com.example.orders_and_notification_management.Services.ProductService;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class OrderFactory implements IOrderFactory{

    ProductService productService;
    AccountService accountService;
    NotificationService notificationService;

    public OrderFactory(ProductService productService, AccountService accountService , NotificationService notificationService){
        this.productService = productService;
        this.accountService = accountService;
        this.notificationService = notificationService;
    }
    public Order createOrder(Order order){
        if(order instanceof SimpleOrder)
            return setOrder((SimpleOrder)order);
        else if(order instanceof CompoundOrder)
            return setOrder((CompoundOrder)order);
        return null;
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
        order.setTotalPrice(total);
        order.setProducts(products);
        order.setAccount(accountService.getAccount(order.getAccount().getEmail()));
        if(total > order.getAccount().getBalance()) {
            return null;
        }

        accountService.deduceBalance(total, order.getAccount());
        order.setStatus(OrderStatus.PLACED);
        order.setPlacementCancelDeadline(LocalDateTime.now().plusMinutes(1));
        notificationService.sendPlacementNotification(order.getAccount(), order);
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
}
