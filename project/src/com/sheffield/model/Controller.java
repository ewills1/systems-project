package com.sheffield.model;
import java.math.BigDecimal;

public class Controller extends Product{

    private Type type;
     
    enum Type {
        STANDARD, DCC, DCC_ELITE;
    }

    public Controller (String name, String code, String brandName, int quantity, BigDecimal price, Type type){
        super(name, code, brandName, quantity, price);
        this.type = type;
    }

    public Type getType(){
        return type;
    }

    public void setType(Type type) {
        if (isValidType(type)) {
            this.type = type;
        } else {
            throw new IllegalArgumentException("This type of controller is not valid");
        }
    }

    public boolean isValidType (Type type) {
        return type != null;
    }
}
