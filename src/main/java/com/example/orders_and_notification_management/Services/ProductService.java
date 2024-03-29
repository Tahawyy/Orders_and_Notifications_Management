package com.example.orders_and_notification_management.Services;

import com.example.orders_and_notification_management.Models.Product;
import com.example.orders_and_notification_management.Repositories.Products;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class ProductService {
    @Autowired
    private Products products;
    @Autowired
    private CategoryService categoryService;

    public ArrayList<Product> getProducts() {
        return products.getProducts();
    }

    public Boolean addProduct(Product product) {
        if (products.getProduct(product.getSerialNumber()) == null) {
            products.addProduct(product);
            if (categoryService.getCategory(product.getCategory().getName()) == null) {
                categoryService.addCategory(product.getCategory());
            } else {
                product.setCategory(categoryService.getCategory(product.getCategory().getName()));
            }
            // increment the remaining quantity of the category
            product.getCategory().setRemainingQuantity(product.getCategory().getRemainingQuantity() + product.getQuantity());
            return true;
        } else {
            return false;
        }
    }

    public Boolean removeProduct(Product product) {
        if (products.getProduct(product.getSerialNumber()) != null) {
            products.removeProduct(product);
            return true;
        }
        return false;

    }

    public Boolean updateProduct(Product product) {
        if (products.getProduct(product.getSerialNumber()) != null) {
            products.updateProduct(product);
            return true;
        }
        return false;

    }

    public Product getProduct(String serialNumber) {
        return products.getProduct(serialNumber);
    }


}
