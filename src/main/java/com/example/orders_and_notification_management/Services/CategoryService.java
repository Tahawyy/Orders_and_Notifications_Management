package com.example.orders_and_notification_management.Services;


import com.example.orders_and_notification_management.Models.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.orders_and_notification_management.Repositories.Categories;

import java.util.ArrayList;

@Service
public class CategoryService {
    @Autowired
    private Categories categories;

    public ArrayList<Category> getCategories() {
        return categories.getCategories();
    }
    public Boolean addCategory(Category category) {
        if(categories.getCategory(category.getName()) == null) {
            categories.addCategory(category);
            return true;
        }
        else {
            return false;
        }
    }
    public Category getCategory(String name) {
        return categories.getCategory(name);
    }
    public Boolean removeCategory(Category category) {
        if(categories.getCategory(category.getName()) != null) {
            categories.deleteCategory(category.getName());
            return true;
        }
        return false;

    }
    public int getRemainingQuantity(String name) {
        return categories.getCategory(name).getRemainingQuantity();
    }

}
