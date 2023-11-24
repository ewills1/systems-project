package com.sheffield.model;
import java.math.BigDecimal;

public class TrainSet extends Product{

    private Type type;

    enum Type {ANALOGUE, DCC_READY, DCC_FITTED, DCC_SOUND};

    public TrainSet(String productCode, String name, String brandName, int quantity, BigDecimal price, Type  type){
        super(productCode, name, brandName, quantity, price)
    }
}