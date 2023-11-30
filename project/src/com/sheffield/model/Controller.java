
package com.sheffield.model;


import java.math.BigDecimal;


public class Controller extends Product {


    private String controllerType;


    public Controller(String name, String code, String brandName, int quantity, BigDecimal price, String gaugeScale,
            String controllerType) {
        super(name, code, brandName, quantity, price, gaugeScale);
        this.controllerType = controllerType;
    }


    public String getControllerType() {
        return controllerType;
    }


    public void setControllerType(String controllerType) {
        if (isValidControllerType(controllerType)) {
            this.controllerType = controllerType;
        } else {
            throw new IllegalArgumentException("This type of controller is not valid");
        }
    }


    public boolean isValidControllerType(String controllerType) {
        return controllerType != null && controllerType.length() <= 100;
    }


}

    // private Type type;
     
    // enum Type {
    //     STANDARD, DCC, DCC_ELITE;
    // }

    // public Controller (String name, String code, String brandName, int quantity, BigDecimal price, Type type){
    //     super(name, code, brandName, quantity, price);
    //     this.type = type;
    // }

    // public Type getType(){
    //     return type;
    // }

    // public void setType(Type type) {
    //     if (isValidType(type)) {
    //         this.type = type;
    //     } else {
    //         throw new IllegalArgumentException("This type of controller is not valid");
    //     }
    // }

    // public boolean isValidType (Type type) {
    //     return type != null;
    // }

    // redefined Controller Class
