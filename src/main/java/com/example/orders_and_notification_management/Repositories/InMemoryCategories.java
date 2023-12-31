package com.example.orders_and_notification_management.Repositories;


import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import com.example.orders_and_notification_management.Models.Category;

@Repository
public class InMemoryCategories implements Categories {
    private ArrayList<Category> categories = new ArrayList<Category>();
    @Override
    public ArrayList<Category> getCategories() {
        return categories;
    }
    @Override
    public void addCategory(Category category) {
        categories.add(category);
    }
    @Override
    public Category getCategory(String name) {
        for(Category category : categories) {
            if(category.getName().equals(name)) {
                return category;
            }
        }
        return null;
    }
    @Override
    public void deleteCategory(String name) {
        for(Category category : categories) {
            if(category.getName().equals(name)) {
                categories.remove(category);
                break;
            }
        }
    }


}
