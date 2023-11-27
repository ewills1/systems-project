package com.sheffield.model;
import java.math.BigDecimal;

public class RollingStock extends Product{

private String era;
private String rollingStockType;

    enum Type {
        CARRIAGE, WAGON;
    }

    public RollingStock(String productCode, String name, String brandName, int quantity, BigDecimal price, String gaugeScale, String era, String rollingStockType){
        super(productCode, name, brandName, quantity, price, gaugeScale);
        this.era = era;
        this.rollingStockType = rollingStockType;
    }

    public String getRollingStockType(){
        return rollingStockType;
    }

    public String getEra(){
        return era;
    }

    public void setRollingStockType(Type type) {
        if (isValidType(type)) {
            this.rollingStockType = rollingStockType;
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
        return era != null && era.length() <= 50;
    }
}