package com.task.productservice.domains.product.controller;

import com.task.productservice.domains.product.model.Product;
import com.task.productservice.domains.product.model.dto.AddProductsDTO;
import com.task.productservice.domains.product.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("product")
public class ProductController {

    private final IProductService productService;

    @Autowired
    public ProductController(IProductService productService) {
        this.productService = productService;
    }

    @PostMapping("/add")
    public ResponseEntity<String> addProducts(@RequestBody AddProductsDTO request) {
        productService.addProducts(request);
        return ResponseEntity.ok("Products added successfully");
    }

    @GetMapping("/all")
    public List<Product> getAllProducts() {
        return productService.getAllProducts();
    }
}
