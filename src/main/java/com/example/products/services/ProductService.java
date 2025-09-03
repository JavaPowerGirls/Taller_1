package com.example.products.services;

import com.example.products.model.Product;
import java.util.List;

/**
 * Service interface for managing Products.
 */


public interface ProductService {

    Product create(Product product);

    List<Product> getAll();

    Product getById(String id);

    Product update(String id, Product product);

    void delete(String id);

    Product purchase(String id, int quantity);

    Product addStock(String id, int quantity);
}
