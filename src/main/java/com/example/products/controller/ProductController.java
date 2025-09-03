package com.example.products.controller;

import com.example.products.model.Product;
import com.example.products.repository.ProductRepository;
import com.example.products.services.ProductService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {


    private final ProductService service;

    public ProductController(ProductService productService) {
        this.service = productService;
    }



    @PostMapping
    public Product create(@RequestBody Product product) {
        // TODO: implement service call
        return null;
    }

    @GetMapping
    public List<Product> getAll() {
        // TODO: implement service call
        return null;
    }

    /**
     * Get product by ID.
     */
    @GetMapping("/{id}")
    public Product getById(@PathVariable String id) {
        // TODO: implement service call
        return null;
    }

    /**
     * Update product (except stock).
     */
    @PutMapping("/{id}")
    public Product update(@PathVariable String id, @RequestBody Product product) {
        // TODO: implement service call
        return null;
    }

    /**
     * Delete product by ID.
     */
    @DeleteMapping("/{id}")
    public void delete(@PathVariable String id) {
        // TODO: implement service call
    }

    /**
     * Add stock to a product.
     */
    @PatchMapping("/{id}/addStock")
    public Product addStock(@PathVariable String id, @RequestParam int quantity) {
        // TODO: implement service call
        return null;
    }

    /**
     * Purchase a product (reduce stock).
     */
    @PostMapping("/{id}/purchase")
    public Product purchase(@PathVariable String id, @RequestParam int quantity) {
        // TODO: implement service call
        return null;
    }





}
