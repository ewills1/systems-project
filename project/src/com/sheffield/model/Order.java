package com.sheffield.model;
import java.util.Date;
import java.util.List;

public class Order {
    
    private String orderID;
    private Date date;
    private double cost;
    private Completed completed;
    private List<OrderLine> orderLines;

    enum Completed {
        PENDING,
        CONFIRMED,
        FULFILLED
    }

    public Order(String orderID, List<OrderLine> orderLines, Date date, Completed completed){
        this.orderID = orderID;
        this.orderLines = orderLines;
        this.date = date;
        this.completed = completed;
    }

    public String getOrderID(){
        return orderID;
    }

    public void setOrderID(String orderID){
        this.orderID = orderID;
    }

    public Date getDate(){
        return date;
    }

    public void setDate(Date date){
        this.date = date;
    }

    public Completed getCompleted(){
        return completed;
    }

    public void setCompleted(Completed completed){
        this.completed = completed;
    }

    public void addOrderLine(OrderLine o){
        orderLines.add(o);
    }

    public void removeOrderLine(OrderLine o){
        orderLines.remove(o);
    }

    public double getTotalCost(){
        double cost = 0;
        for (OrderLine o : orderLines){
            cost += o.getCost();
        }
        return cost;
    }

    @Override
    public String toString(){
       return "OrderID: "+orderID+ ", OrderLines: "+ orderLines.toString()
        +",  Date: "+date+", Completed: "+completed;
    }
}
