package com.example.orders_and_notification_management.Repositories;



import com.example.orders_and_notification_management.Models.Product;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;


@Repository

public class Products implements ProductsRepositry{
    private ArrayList<Product> products = new ArrayList<>();
    @Override
    public ArrayList<Product> getProducts() {
        return products;
    }
    @Override
    public void addProduct(Product product) {
        products.add(product);
    }
    @Override
    public void removeProduct(Product product) {
        products.remove(product);
    }
    @Override
    public Product getProduct(String serialNumber) {
        for (Product p : products) {
            if (p.getSerialNumber().equals(serialNumber)) {
                return p;
            }
        }
        return null;
    }
    @Override
    public void updateProduct(Product product) {
        for (Product p : products) {
           if(product.getSerialNumber().equals(p.getSerialNumber())) {
               p.setProductName(product.getProductName());
               p.setCategory(product.getCategory());
               p.setVendor(product.getVendor());
               p.setPrice(product.getPrice());
           }
        }
    }
}
