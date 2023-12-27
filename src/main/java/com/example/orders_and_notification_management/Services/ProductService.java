package com.example.orders_and_notification_management.Services;


import com.example.orders_and_notification_management.Models.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.orders_and_notification_management.Repositories.Products;

import java.util.ArrayList;

@Service
public class ProductService {
    @Autowired
    private Products products;
    public ArrayList<Product> getProducts() {
        return products.getProducts();
    }
    public void addProduct(Product product) {
        products.addProduct(product);
    }
    public void removeProduct(Product product) {
        products.removeProduct(product);
    }
    public void updateProduct(Product product) {
        products.updateProduct(product);
    }
    public Product getProduct(String serialNumber) {
        return products.getProduct(serialNumber);
    }


}
