package com.example.products.services.impl;

import com.example.products.model.Product;
import com.example.products.repository.ProductRepository;
import com.example.products.services.ProductService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;

    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public Product create(Product product) {
        productRepository.save(product);
        return product;
    }

    @Override
    public List<Product> getAll() {
        return productRepository.findAll();
    }

    @Override
    public Product getById(String id) {
        return productRepository.findById(id)
        .orElseThrow(()  -> new RuntimeException( "Product not found with id" + id));
    }

    @Override
    public Product update(String id, Product product) {
        Product existingProduct = getById(id);
        existingProduct.setName(product.getName());
        existingProduct.setPrice(product.getPrice());
        return productRepository.save(existingProduct);
    }

    @Override
    public void delete(String id) {
        productRepository.deleteById(id);

    }

    @Override
    public Product purchase(String id, int quantity) {
        Product existingProduct = getById(id);
        if (existingProduct.getStock() < quantity) {
            throw new RuntimeException("Not enough stock for product with id" + id);
        }
        existingProduct.setStock(existingProduct.getStock() - quantity);
        return productRepository.save(existingProduct);

    }


    @Override
    public Product addStock(String id, int quantity) {
        Product existingProduct = getById(id);
        existingProduct.setStock(existingProduct.getStock() + quantity);
        return productRepository.save(existingProduct);
    }
}
