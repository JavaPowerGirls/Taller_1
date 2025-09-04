package com.example.products.controller;

import com.example.products.model.Product;
import com.example.products.repository.ProductRepository;
import com.example.products.services.ProductService;
import org.springframework.web.bind.annotation.RequestBody;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {
    private final ProductService productService;
    public ProductController(ProductService productService){
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
    public Product createProduct(@RequestBody Product product) {
        return productService.create(product);
    }

    @PutMapping("/{id}")
    public Product updateProduct(@PathVariable String id, @RequestBody Product product) {
        return productService.update(id, product);
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
















