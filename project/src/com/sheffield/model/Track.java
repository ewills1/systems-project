package com.sheffield.model;
import java.math.BigDecimal;

public class Track extends Product {
    
    public Track(String productCode, String name, String brandName, int quantity, BigDecimal price) {
        super(productCode, name, brandName, quantity, price);
    }
}