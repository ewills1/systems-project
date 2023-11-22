package com.sheffield.model;

import java.math.BigDecimal;

import javax.sound.sampled.AudioFileFormat.Type;

public class Controller extends Product{

    private Type type;
     
    enum Type {
        STANDARD,
        DCC,
        DCC_ELITE
    }

    public Controller (String name, String code, String brandName, int quantity, BigDecimal price, Type type){
        super(name, code, brandName, quantity, price);
        this.type = type;
    }

    public Type getType(){
        return type;
    }


}
