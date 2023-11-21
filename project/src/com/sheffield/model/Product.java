package com.sheffield.model;
import java.math.BigDecimal;


public class Product {
    private String code;
    private String name;
    private String brandName;
    private int quantity;
    private BigDecimal price;


    // Constructor to initialize a Book object with its attributes
    public Product(String name, String code, String brandName, int quantity, BigDecimal price) {
        this.setCode(code);
        this.setName(name);
        this.setBrandName(brandName);
        this.setQuantity(quantity);
        this.setPrice(price);
    }

    // Getter and setter methods for the Code attribute with validation
    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        if (isValidCode(code)) {
            this.code = code;
        } else {
            throw new IllegalArgumentException("Product code is not valid.");
        }
    }

    // Getter and setter methods for the Name attribute with validation
    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (isValidName(name)) {
            this.name = name;
        } else {
            throw new IllegalArgumentException("Product name is not valid.");
        }
    }

    // Getter and setter methods for the BrandName attribute with validation
    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        if (isValidBrandName(brandName)) {
            this.brandName = brandName;
        } else {
            throw new IllegalArgumentException("Brand name is not valid.");
        }
    }

    // Getter and setter methods for the Quantity attribute with validation
    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        if (isValidQuantity(quantity)) {
            this.quantity = quantity;
        } else {
            throw new IllegalArgumentException("Quantity is not valid.");
        }
    }

    // Getter and setter methods for the Price attribute with validation
    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        if (isValidPrice(price)) {
            this.price = price;
        } else {
            throw new IllegalArgumentException("Price is not valid.");
        }
    }

    // Private validation methods for each attribute
    private boolean isValidCode(String code) {
        // Product code is a single letter followed by a 3 to 5 digit serial number
        return code != null && code.length() >= 4 && code.length() <= 6;
    }

    private boolean isValidName(String name) {
        return name != null && name.length() <= 100;
    }

    private boolean isValidBrandName(String brandName) {
        return brandName != null && brandName.length() <= 100;
    }

    private boolean isValidQuantity(int quantity) {
        return quantity >= 0;
    }

    // private boolean isValidCopiesAvailable(int copiesAvailable) {
    //     // Implement copies available validation logic here (e.g., non-negative)
    //     return copiesAvailable >= 0;
    // }

    private boolean isValidPrice(BigDecimal price) {
        // price must be non-negative
        return price != null && price.compareTo(BigDecimal.ZERO) >= 0;
    }


    @Override
    public String toString() {
        return "{ " +
            " code='" + getCode() + "'" +
            ", name='" + getName() + "'" +
            ", brandName='" + getBrandName() + "'" +
            ", quantity='" + getQuantity() + "'" +
            ", price='" + getPrice() + "'" +
            " }";
    }
}