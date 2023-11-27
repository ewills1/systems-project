package com.sheffield.model;
import java.math.BigDecimal;

public class RollingStock extends Product{

private String era;
private Type type;

    enum Type {
        CARRIAGE, WAGON;
    }

    public RollingStock(String productCode, String name, String brandName, int quantity, BigDecimal price, String era, Type type){
        super(productCode, name, brandName, quantity, price);
        this.era = era;
        this.type = type;
    }

    public Type getType(){
        return type;
    }

    public String getEra(){
        return era;
    }

    public void setType(Type type) {
        if (isValidType(type)) {
            this.type = type;
        } else {
            throw new IllegalArgumentException("This type of rolling stock is not valid");
        }
    }

    public void setEra(String era) {
        if (isValidEra(era)) {
            this.era = era;
        } else {
            throw new IllegalArgumentException("era is not valid.");
        }
    }

    public boolean isValidType (Type type) {
        return type != null;
    }

    public boolean isValidEra (String era) {
        return era != null && era <= 50;
    }
}