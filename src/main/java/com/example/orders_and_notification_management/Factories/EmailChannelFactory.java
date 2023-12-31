package com.example.orders_and_notification_management.Factories;
import com.example.orders_and_notification_management.NotificationSystem.NotificationChannel;
import com.example.orders_and_notification_management.NotificationSystem.EMail;
public class EmailChannelFactory extends ChannelFactory {
    @Override
    public NotificationChannel createChannel(String receiverInfo) {
       if(receiverInfo.equals("Email")){
           return new EMail(account.getEmail());
       }
       return null;
    }
}
