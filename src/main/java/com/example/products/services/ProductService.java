package com.example.products.services;

import java.util.List;

import com.example.products.dto.ProductCreateDto;
import com.example.products.dto.ProductUpdateDto;
import com.example.products.model.Product;



public interface ProductService {
    
    Product create(ProductCreateDto productCreateDto);

    List<Product> getAll();

    Product getById(String id);
    
    Product update(String id, ProductUpdateDto productUpdateDto);

    void delete(String id);

    Product purchase(String id, int quantity);

    Product addStock(String id, int quantity);
}
