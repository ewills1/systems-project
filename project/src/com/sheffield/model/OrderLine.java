package com.sheffield.model;
import java.math.BigDecimal;
import java.sql.Connection;

public class OrderLine {
    
    private String productCode;
    private int lineNumber;
    private int quantity;
    private BigDecimal cost;

    public OrderLine(int lineNumber, String productID, int quantity){
        this.lineNumber = lineNumber;
        this.productCode = productID;
        this.quantity = quantity;
    }

    public int getLineNumber(){
        return lineNumber;
    }

    public void setLineNumber(int lineNumber){
        this.lineNumber = lineNumber;
    }

    public int getQuantity(){
        return quantity;
    }

    public void setQuantity(int quantity){
        this.quantity = quantity;
    }

    // public BigDecimal getCost(Connection connection){
    //     Product.getProductByCode(productCode, connection).getCost() * quantity;
    // }

    @Override
    public String toString(){
        return "Order line: "+ lineNumber + ", "+productCode+", "+quantity; //+cost
    }





}
