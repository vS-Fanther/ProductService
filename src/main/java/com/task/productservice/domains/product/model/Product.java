package com.task.productservice.domains.product.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String entryDate;
    private String itemCode;
    private String itemName;
    private String itemQuantity;
    private String status;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEntryDate() {
        return entryDate;
    }

    public void setEntryDate(String entryDate) {
        this.entryDate = entryDate;
    }

    public String getItemCode() {
        return itemCode;
    }

    public void setItemCode(String itemCode) {
        this.itemCode = itemCode;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public String getItemQuantity() {
        return itemQuantity;
    }

    public void setItemQuantity(String itemQuantity) {
        this.itemQuantity = itemQuantity;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        Product product;

        public Builder() {
            product = new Product();
        }

        public Builder entryDate(String entryDate) {
            product.entryDate = entryDate;
            return this;
        }

        public Builder itemCode(String itemCode) {
            product.itemCode = itemCode;
            return this;
        }

        public Builder itemName(String itemName) {
            product.itemName = itemName;
            return this;
        }

        public Builder itemQuantity(String itemQuantity) {
            product.itemQuantity = itemQuantity;
            return this;
        }

        public Builder status(String status) {
            product.status = status;
            return this;
        }

        public Product build() {
            return product;
        }
    }
}
