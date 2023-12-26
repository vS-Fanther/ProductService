package com.task.productservice.domains.product.service;

import com.task.productservice.domains.product.model.Product;
import com.task.productservice.domains.product.model.dto.AddProductsDTO;

import java.util.List;

public interface IProductService {
    public void addProducts(AddProductsDTO request);

    public List<Product> getAllProducts();
}
