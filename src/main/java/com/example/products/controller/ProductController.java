package com.example.products.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.products.dto.ProductCreateDto;
import com.example.products.dto.ProductUpdateDto;
import com.example.products.model.Product;
import com.example.products.services.ProductService;

@RestController
@RequestMapping("/products")
public class ProductController {
    private final ProductService productService;
    
    public ProductController(ProductService productService) {
     this.productService = productService;
    }

    @GetMapping
    public List<Product> getAllProducts() {
        return productService.getAll();
    }

    @GetMapping("/{id}")
    public Product getProductById(@PathVariable String id) {
        return productService.getById(id);
    }
    @PostMapping
    public Product createProduct(@Valid @RequestBody ProductCreateDto productCreateDto) {
        return productService.create(productCreateDto);
    }

    @PutMapping("/{id}")
    public Product updateProduct(@PathVariable String id, @Valid @RequestBody ProductUpdateDto productUpdateDto) {
        return productService.update(id, productUpdateDto);
    }

    @DeleteMapping("/{id}")
    public void deleteAccount(@PathVariable String id ) {
        productService.delete(id);
    }
    @PostMapping("/{id}/purchase")
    public Product purchaseProduct(@PathVariable String id, @RequestParam int quantity) {
        return productService.purchase(id, quantity);
    }
    @PatchMapping ("/{id}/addStock")
    public Product addProduct(@PathVariable String id, @RequestParam int quantity ) {
        return productService.addStock(id, quantity);
    }
}
















