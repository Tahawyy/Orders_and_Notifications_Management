package com.example.orders_and_notification_management.Repositories;


import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import com.example.orders_and_notification_management.Models.Category;

@Repository
public class Categories {
    private ArrayList<Category> categories = new ArrayList<Category>();
    public ArrayList<Category> getCategories() {
        return categories;
    }
    public void addCategory(Category category) {
        categories.add(category);
    }
    public Category getCategory(String name) {
        for(Category category : categories) {
            if(category.getName().equals(name)) {
                return category;
            }
        }
        return null;
    }
    public void deleteCategory(String name) {
        for(Category category : categories) {
            if(category.getName().equals(name)) {
                categories.remove(category);
                break;
            }
        }
    }


}
