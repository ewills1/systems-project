package com.sheffield.model;

import java.math.BigDecimal;

public class Locomotive extends Product {

    // private Type type;
    // private String era;

    // enum Type {
    //     ANALOGUE, DCC_READY, DCC_FITTED, DCC_SOUND;
    // }

    // public Locomotive(String productCode, String name, String brandName, int quantity, BigDecimal price, Type type,
    //         String era) {
    //     super(productCode, name, brandName, quantity, price);
    //     this.type = type;
    //     this.era = era;
    // }

    // public Type getType() {
    //     return type;
    // }

    // public String getEra() {
    //     return era;
    // }

    // public void setType(Type type) {
    //     if (isValidType(type)) {
    //         this.type = type;
    //     } else {
    //         throw new IllegalArgumentException("This type of locomotive is not valid");
    //     }
    // }

    // public void setEra(String era) {
    //     if (isValidEra(era)) {
    //         this.era = era;
    //     } else {
    //         throw new IllegalArgumentException("Era is not valid");
    //     }
    // }

    // public boolean isValidType(Type type) {
    //     return type != null;
    // }

    // public boolean isValidEra(String era) {
    //     return era != null && era.length() <= 50;
    // }

    // redefine locomotives class
    private String era;
    private String controllerType;
    

    public Locomotive(String productCode, String name, String brandName, int quantity, BigDecimal price, String gaugeScale, String era, String controllerType){
        super(productCode, name, brandName, quantity, price, gaugeScale);
        this.era = era;
        this.controllerType = controllerType;
    }

    public void setEra(String era) {
        this.era = era;
    }

    public String getEra() {
        return era;
    }

    public void setControllerType(String controllerType) {
        this.controllerType = controllerType;
    }

    public String getControllerType() {
        return controllerType;
    }
}