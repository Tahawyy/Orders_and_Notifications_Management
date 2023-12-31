package com.example.orders_and_notification_management.Repositories;

import com.example.orders_and_notification_management.Models.Category;

import java.util.ArrayList;

public interface Categories {
    public ArrayList<Category> getCategories();
    public void addCategory(Category category);
    public Category getCategory(String name);
    public void deleteCategory(String name);
}
