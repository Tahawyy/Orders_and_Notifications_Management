package com.example.orders_and_notification_management.Services;


import com.example.orders_and_notification_management.Models.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.orders_and_notification_management.Repositories.Categories;

import java.util.ArrayList;

@Service
public class CategoryService {
    @Autowired
    private Categories categoryRepository;

    public ArrayList<Category> getCategories() {
        return categoryRepository.getCategories();
    }
    public Boolean addCategory(Category category) {
        if(categoryRepository.getCategory(category.getName()) == null) {
            categoryRepository.addCategory(category);
            return true;
        }
        else {
            return false;
        }
    }
    public Category getCategory(String name) {
        return categoryRepository.getCategory(name);
    }
    public void deleteCategory(String name) {
        categoryRepository.deleteCategory(name);
    }
    public int getRemainingQuantity(String name) {
        return categoryRepository.getCategory(name).getRemainingQuantity();
    }

}
