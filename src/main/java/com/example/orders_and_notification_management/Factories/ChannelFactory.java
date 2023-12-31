package com.example.orders_and_notification_management.Factories;
import com.example.orders_and_notification_management.Models.Account;
import com.example.orders_and_notification_management.NotificationSystem.EMail;
import com.example.orders_and_notification_management.NotificationSystem.NotificationChannel;
import com.example.orders_and_notification_management.NotificationSystem.SMS;

public  class ChannelFactory implements IChannelFactory{

    public  NotificationChannel createChannel(Account account ){
        if(account.getPrefferedChannel().equals("SMS"))
            return new SMS(account.getPhoneNumber());
        return  new EMail(account.getEmail());
    }
}
