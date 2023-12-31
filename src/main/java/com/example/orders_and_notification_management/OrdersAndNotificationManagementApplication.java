package com.example.orders_and_notification_management;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class OrdersAndNotificationManagementApplication {

    public static void main(String[] args) {
        SpringApplication.run(OrdersAndNotificationManagementApplication.class, args);
    }

}
