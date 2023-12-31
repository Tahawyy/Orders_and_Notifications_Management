package com.example.orders_and_notification_management.Services;


import com.example.orders_and_notification_management.Factories.IOrderFactory;
import com.example.orders_and_notification_management.Factories.IOrderManagerFactory;
import com.example.orders_and_notification_management.Factories.OrderFactory;
import com.example.orders_and_notification_management.Factories.OrderManagerFactory;
import com.example.orders_and_notification_management.Manager.OrderManager;
import com.example.orders_and_notification_management.Models.*;
import com.example.orders_and_notification_management.Repositories.Orders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public  class OrderService {
    @Autowired
    protected static Orders orders;
    @Autowired
    protected ProductService productService;
    @Autowired
    protected AccountService accountService;
    @Autowired
    protected NotificationService notificationService;

    public OrderService(Orders orders) {
        this.orders = orders;
    }
    public ArrayList<Order> getOrders() {
        return orders.getOrders();
    }

    public Boolean placeOrder(Order order) {
        IOrderFactory orderFactory = new OrderFactory(productService, accountService, notificationService);
        if(orders.getOrder(order.getSerialNumber()) == null) {
            order = orderFactory.createOrder(order ,orders.getOrders().size()+1+"" );
            orders.addOrder(order);
            return true;
        }
        return false;
    }
    public   Order getOrder(String serialNumber) {
        return orders.getOrder(serialNumber);
    }
    public Boolean shipOrder(String SerialNumber){
        IOrderManagerFactory orderManagerFactory = new OrderManagerFactory(this, accountService, notificationService);
        OrderManager orderManager = orderManagerFactory.createOrderManager(SerialNumber);
        return orderManager.shipOrder(SerialNumber);
    }
    public Boolean cancelPlacement(String SerialNumber) {
        IOrderManagerFactory orderManagerFactory = new OrderManagerFactory(this,  accountService, notificationService);
        OrderManager orderManager = orderManagerFactory.createOrderManager(SerialNumber);
        return orderManager.cancelPlacement(SerialNumber);
    }
    public  Boolean cancelShipping(String SerialNumber){
        IOrderManagerFactory orderManagerFactory = new OrderManagerFactory(this,  accountService, notificationService);
        OrderManager orderManager = orderManagerFactory.createOrderManager(SerialNumber);
        return orderManager.cancelShipping(SerialNumber);
    }

}
