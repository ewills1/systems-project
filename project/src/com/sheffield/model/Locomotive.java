package com.sheffield.model;
import java.math.BigDecimal;

public class Locomotive extends Product{

    private Type type;

    enum Type {
        ANALOGUE, DCC_READY, DCC_FITTED, DCC_SOUND;
    }

    public Locomotive(String productCode, String name, String brandName, int quantity, BigDecimal price){
        super(productCode, name, brandName, quantity, price);
    }

    public Type getType(){
        return type;
    }

    public void setType(Type type) {
        if (isValidType(type)) {
            this.type = type;
        } else {
            throw new IllegalArgumentException("This type of locomotive is not valid");
        }
    }

    public boolean isValidType (Type type) {
        return type != null;
    }
}