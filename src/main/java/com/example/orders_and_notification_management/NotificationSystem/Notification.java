package com.example.orders_and_notification_management.NotificationSystem;

import com.example.orders_and_notification_management.Models.Account;

import java.util.HashMap;

public abstract class Notification {
    private Account receiver;
    private String subject;
    private String content;
    private NotificationChannel channel;
    private HashMap<String, String> contentLanguageMap;

    public Notification() {
        this.contentLanguageMap = new HashMap<>();
    }

    public Account getReceiver() {
        return receiver;
    }

    public void setReceiver(Account receiver) {
        this.receiver = receiver;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public NotificationChannel getChannel() {
        return channel;
    }

    public void setChannel(NotificationChannel channel) {
        this.channel = channel;
    }

    public HashMap<String, String> getContentLanguageMap() {
        return contentLanguageMap;
    }

    public void setContentLanguageMap(HashMap<String, String> contentLanguageMap) {
        this.contentLanguageMap = contentLanguageMap;
    }

    public void sendNotification() {
        this.channel.sendNotification(this);
    }
}
