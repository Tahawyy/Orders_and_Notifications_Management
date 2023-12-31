package com.example.orders_and_notification_management.NotificationSystem;

public class EMail implements NotificationChannel {
    String email;
    public EMail(String email) {
        this.email = email;
    }
    @Override
    public boolean sendNotification(Notification notification) {
        return true;
    }
    @Override
    public String getReceiverInfo(){
        return email;
    }
}
