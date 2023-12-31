package com.example.orders_and_notification_management.Services;

import com.example.orders_and_notification_management.Models.Account;
import com.example.orders_and_notification_management.Models.SimpleOrder;
import com.example.orders_and_notification_management.NotificationSystem.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class NotificationService {
    Queue<Notification> notifications;
    Map<String, Integer> receiversCount;
    Map<String, Integer> templateCount;

    public NotificationService() {
        notifications = new LinkedList<>();
        receiversCount = new HashMap<>();
        templateCount = new HashMap<>();
    }

    @Scheduled(fixedRate = 60000)
    public void sendNotifications() {
        if (!notifications.isEmpty()) {
            Notification notification = notifications.poll();
            notification.getChannel().sendNotification(notification);
            if (receiversCount.containsKey(notification.getChannel().getReceiverInfo()))
                receiversCount.put(notification.getChannel().getReceiverInfo(), receiversCount.get(notification.getChannel().getReceiverInfo()) + 1);
            else
                receiversCount.put(notification.getChannel().getReceiverInfo(), 1);

            if (templateCount.containsKey(notification.getClass().getSimpleName()))
                templateCount.put(notification.getClass().getSimpleName(), templateCount.get(notification.getClass().getSimpleName()) + 1);
            else
                templateCount.put(notification.getClass().getSimpleName(), 1);

        }
    }
    public void sendPlacementNotification(Account account, SimpleOrder order) {
        NotificationChannel channel;
        if(account.getPrefferedChannel().equals("Email"))
            channel = new EMail(account.getEmail());
        else if(account.getPrefferedChannel().equals("SMS"))
            channel = new SMS(account.getPhoneNumber());
        else
            channel = new EMail(account.getEmail());

        PlacementNotification notification = new PlacementNotification(account, channel, order);
        notification.selectLanguage(account.getPrefferedLanguage());
        notification.assignPlaceholders();
        notifications.add(notification);
    }
    public void sendShipmentNotification(Account account, SimpleOrder order) {
        NotificationChannel channel;
        if(account.getPrefferedChannel().equals("Email"))
            channel = new EMail(account.getEmail());
        else if(account.getPrefferedChannel().equals("SMS"))
            channel = new SMS(account.getPhoneNumber());
        else
            channel = new EMail(account.getEmail());
        ShipmentNotification notification = new ShipmentNotification(account, channel, order);
        notification.selectLanguage(account.getPrefferedLanguage());
        notification.assignPlaceholders();
        notifications.add(notification);
    }
    public ArrayList<Notification> getNotifications() {
        ArrayList<Notification> notificationsList = new ArrayList<>();
        for(Notification notification : notifications) {
            notificationsList.add(notification);
        }
        return notificationsList;
    }
    public String getStatistics() {
        String statistics = "";
        statistics += "Number of receivers: " + receiversCount.size() + ", ";
        statistics += "Number of templates: " + templateCount.size() + ", ";
        statistics += "Most used template: " + Collections.max(templateCount.entrySet(), Map.Entry.comparingByValue()).getKey() + ", ";
        statistics += "Most active receiver: " + Collections.max(receiversCount.entrySet(), Map.Entry.comparingByValue()).getKey() + ".";
        return statistics;
    }
}
