package com.example.orders_and_notification_management.NotificationSystem;

public class SMS implements NotificationChannel{
    String phoneNumber;
    public SMS(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
    @Override
    public boolean sendNotification(Notification notification) {
        return true;
    }
    @Override
    public String getReceiverInfo(){
        return phoneNumber;
    }
}
