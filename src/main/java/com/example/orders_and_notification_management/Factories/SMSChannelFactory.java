package com.example.orders_and_notification_management.Factories;
import com.example.orders_and_notification_management.NotificationSystem.NotificationChannel;
import com.example.orders_and_notification_management.NotificationSystem.SMS;

public class SMSChannelFactory extends ChannelFactory {
    @Override
    public NotificationChannel createChannel(String receiverInfo) {
       if(receiverInfo.equals("SMS")){
           return new SMS(account.getPhoneNumber());
       }
       return null;
    }
}


