package com.task.productservice.domains.product.model.dto;

import com.task.productservice.domains.product.model.Product;

import java.util.List;

public class AddProductsDTO {
    private List<Product> records;

    public List<Product> getRecords() {
        return records;
    }

    public void setRecords(List<Product> records) {
        this.records = records;
    }
}
