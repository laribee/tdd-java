package com.laribee.tdd.java;

public class NewOrderItemDTO {

    private double price;
    private String type;
    private String description;
    private String sku;

    public double getPrice() {
        return price;
    }

    public String getType() {
        return type;
    }

    public String getDescription() {
        return description;
    }

    public String getSku() {
        return sku;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setSku(String sku) {
        this.sku = sku;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
