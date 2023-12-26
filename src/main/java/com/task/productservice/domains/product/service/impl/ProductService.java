package com.task.productservice.domains.product.service.impl;

import com.task.productservice.domains.product.model.Product;
import com.task.productservice.domains.product.model.dto.AddProductsDTO;
import com.task.productservice.domains.product.repository.ProductRepository;
import com.task.productservice.domains.product.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService implements IProductService {

    private final ProductRepository productRepository;

    @Autowired
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public void addProducts(AddProductsDTO addProductsDTOs) {
        for (Product productRequest : addProductsDTOs.getRecords()) {
            Product product = Product.builder()
                    .entryDate(productRequest.getEntryDate())
                    .itemCode(productRequest.getItemCode())
                    .itemName(productRequest.getItemName())
                    .itemQuantity(productRequest.getItemQuantity())
                    .status(productRequest.getStatus())
                    .build();
            productRepository.save(product);
        }
    }

    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }
}
