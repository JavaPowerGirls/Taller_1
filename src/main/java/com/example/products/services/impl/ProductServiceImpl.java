package com.example.products.services.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.products.dto.ProductCreateDto;
import com.example.products.dto.ProductMapper;
import com.example.products.dto.ProductUpdateDto;
import com.example.products.model.Product;
import com.example.products.repository.ProductRepository;
import com.example.products.services.ProductService;

@Service
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;
    private final ProductMapper productMapper;

    public ProductServiceImpl(ProductRepository productRepository, ProductMapper productMapper) {
        this.productRepository = productRepository;
        this.productMapper = productMapper;
    }

    @Override
    public Product create(ProductCreateDto productCreateDto) {
        Product product = productMapper.toProduct(productCreateDto);
        return productRepository.save(product);
    }

    @Override
    public List<Product> getAll() {
        return productRepository.findAll()
                .stream() // convierte a stream
                .sorted((p1, p2) -> p1.getName().compareToIgnoreCase(p2.getName())) //ordena alfabeticamente
                .toList(); //convierte a lista
    }

    @Override
    public Product getById(String id) {
        return productRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Product not found with id: " + id));
                 //lambda que lanza error si no encuentra el producto
    }


    @Override
    public Product update(String id, ProductUpdateDto productUpdateDto) {
        Product existingProduct = getById(id);
        Product updatedProduct = productMapper.updateProduct(existingProduct, productUpdateDto);
        return productRepository.save(updatedProduct);
    }

    @Override
    public void delete(String id) {
        productRepository.deleteById(id);

    }

    @Override
    public Product purchase(String id, int quantity) {
        Product existingProduct = getById(id);
        if (existingProduct.getStock() < quantity) {
            throw new RuntimeException("Not enough stock for product with id: " + id);
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
