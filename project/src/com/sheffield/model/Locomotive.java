package com.sheffield.model;
import java.math.BigDecimal;

public class Locomotive extends Product {

    private String era;
    private LocomotiveType locomotiveType;


    public Locomotive(String productCode, String name, String brandName, int quantity, BigDecimal price,
            String gaugeScale, String era, String locomotiveType) {
        super(productCode, name, brandName, quantity, price, gaugeScale);
        this.setEra(era);
        this.setLocomotiveType(locomotiveType);
    }

    public String getEra() {
        return era;
    }

    public void setEra(String era) {
        if (isValidEra(era)) {
            this.era = era;
        } else {
            throw new IllegalArgumentException("Era is not valid");
        }
    }

    public boolean isValidEra(String era) {
        return era != null && era.length() <= 50;
    }

    public LocomotiveType getLocomotiveType() {
        return locomotiveType;
    }

    public void setLocomotiveType(String locomotiveType) {
        try {
            this.locomotiveType = LocomotiveType.valueOf(locomotiveType.toUpperCase());
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("This type of locomotive is not valid");
        }
    }
}

