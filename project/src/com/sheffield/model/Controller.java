
package com.sheffield.model;
import java.math.BigDecimal;

public class Controller extends Product {
    private ControllerType controllerType;
    

    public Controller (String name, String code, String brandName, int quantity, BigDecimal price, String gaugeScale, String controllerType) {
        super(name, code, brandName, quantity, price, gaugeScale);
        this.setControllerType(controllerType);
    }

    public ControllerType getControllerType(){
        return controllerType;
    }

    public void setControllerType(String controllerType) {
        try {
            this.controllerType = ControllerType.valueOf(controllerType.toUpperCase());
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("This type of controller type is not valid.");
        }
    }
}