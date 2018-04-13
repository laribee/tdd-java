package com.laribee.tdd.java;

public class OrderItem implements Voidable {
    private String type;
    private double price;
    private String sku;
    private String description;
    private boolean voided;

    public OrderItem(NewOrderItemDTO newOrderItem) {
        double thePrice = newOrderItem.getPrice();

        this.price = thePrice >= 0.0 ? thePrice : 0.0;

        String theType = newOrderItem.getType();

        if (theType.equals("ELECTRONICS") || theType.equals("APPLIANCES")) {
            this.type = theType;
        } else {
            this.type = "MISCELLANEOUS";
        }

        String theDescription = newOrderItem.getDescription();

        if(theDescription == null) {
            throw new NullPointerException();
        }

        this.description = newOrderItem.getDescription();

        String theSku = newOrderItem.getSku();

        if(theSku == null) {
            throw new NullPointerException();
        }
        this.sku = newOrderItem.getSku();
    }

    public double getPrice() {
        return this.price;
    }

    public String getType() {
        return this.type;
    }

    public String getDescription() {
        return this.description;
    }

    public String getSku() {
        return this.sku;
    }

    public boolean isVoided() {
        return voided;
    }

    public void makeVoid() {
        voided = true;
    }
}
