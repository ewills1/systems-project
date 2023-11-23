package com.sheffield.model;

public class OrderLine {
    
    private Product product;
    private int lineNumber;
    private int quantity;
    private double cost;

    public OrderLine(int lineNumber, Product product, int quantity){
        this.lineNumber = lineNumber;
        this.product = product;
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

    public Product getProduct(){
        return product;
    }

    public void setProduct(Product p){
        this.product = p;
    }

    public double getCost(){
        double price = product.getPrice().doubleValue();
        double cost = price * quantity;
        return cost;
    }

    @Override
    public String toString(){
        return "Order line: "+ lineNumber + ", Name: "+product.getName()+", Quantity: "+
        quantity+", Price: "+cost; //+cost
    }





}
