package com.example.orders_and_notification_management.Factories;

import com.example.orders_and_notification_management.Manager.OrderManager;

public interface IOrderManagerFactory {
    public OrderManager createOrderManager(String serialNumber);
}
