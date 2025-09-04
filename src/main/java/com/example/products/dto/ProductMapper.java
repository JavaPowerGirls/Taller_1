package com.example.products.dto;

import org.springframework.stereotype.Component;

import com.example.products.model.Product;

@Component
public class ProductMapper {

    public Product toProduct(ProductCreateDto dto) {
        if (dto == null) {
            return null;
        }
        
        Product product = new Product();
        product.setName(dto.getName());
        product.setPrice(dto.getPrice());
        product.setStock(dto.getStock());
        return product;
    }

    public Product updateProduct(Product existingProduct, ProductUpdateDto dto) {
        if (existingProduct == null || dto == null) {
            return existingProduct;
        }
        existingProduct.setName(dto.getName());
        existingProduct.setPrice(dto.getPrice());
        return existingProduct;
    }


    
}
