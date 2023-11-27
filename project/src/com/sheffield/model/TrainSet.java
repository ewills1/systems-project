package com.sheffield.model;
import java.math.BigDecimal;

public class TrainSet extends Product {

    private String era;

    public TrainSet(String productCode, String name, String brandName, int quantity, BigDecimal price, /*Type type,*/ String era){
        super(productCode, name, brandName, quantity, price);
        this.era = era;
    }

    public void setEra(String era) {
        if (isValidEra(era)) {
            this.era = era;
        } else {
            throw new IllegalArgumentException("Era is not valid.");
        }
    }

    public boolean isValidType (Type type) {
        return type != null;
    }

    public boolean isValidEra (String era) {
        return era != null && era <= 50;
    }
}