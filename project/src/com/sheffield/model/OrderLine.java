package com.sheffield.model;

public class OrderLine {
    
    private Product product;
    private int orderID;
    private int quantity;
    private double cost;

    public OrderLine(int lineNumber, Product product, int quantity){
        this.orderID = lineNumber;
        this.product = product;
        this.quantity = quantity;
    }

    public int getOrderID(){
        return orderID;
    }

    public void setOrderID(int lineNumber){
        this.orderID= lineNumber;
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
        return "Order line: "+ orderID + ", Name: "+product.getName()+", Quantity: "+
        quantity+", Price: "+cost; //+cost
    }





}
