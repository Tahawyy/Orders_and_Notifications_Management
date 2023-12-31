package com.example.orders_and_notification_management.NotificationSystem;

import com.example.orders_and_notification_management.Models.Account;

import java.util.ArrayList;
import java.util.HashMap;

public abstract class Notification {
    private Account receiver;
    private String subject;
    private String content;
    private NotificationChannel channel;
    private HashMap<String, String> availableLanguages;

    private String selectedLanguage;

    public Notification(Account receiver, NotificationChannel channel, String subject) {
        this.availableLanguages = new HashMap<>();
        this.receiver = receiver;
        this.channel = channel;
        this.subject = subject;
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


    public void setContentLanguageMap(HashMap<String, String> availableLanguages) {
        this.availableLanguages = Notification.this.availableLanguages;
    }

    public void sendNotification() {
        this.channel.sendNotification(this);
    }
    public void addLanguage(String language, String content) {
        this.availableLanguages.put(language, content);
    }
    public void selectLanguage(String language) {
        if(!this.availableLanguages.containsKey(language)) throw new IllegalArgumentException("Language not available");

        this.selectedLanguage = language;
        this.setContent(this.availableLanguages.get(language));
    }
    public String getSelectedLanguage() {
        return this.selectedLanguage;
    }
    public ArrayList<String> getAvailableLanguages() {
        ArrayList<String> languages = new ArrayList<>();
        for(String language : this.availableLanguages.keySet()) {
            languages.add(language);
        }
        return languages;
    }

    public abstract void assignPlaceholders();
}
