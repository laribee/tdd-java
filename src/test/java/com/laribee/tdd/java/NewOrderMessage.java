package com.laribee.tdd.java;

public class NewOrderMessage {
    private double price;
    private String type;
    private String description;
    private String sku;
    private String theType;

    public void addProduct(String type, String sku, double price, String description) {
        this.theType = type;
        this.sku = sku;
        this.price = price;
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public String getType() {
        return theType;
    }

    public String getDescription() {
        return description;
    }

    public String setSku() {
        return sku;
    }
}
