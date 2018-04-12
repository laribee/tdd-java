package com.laribee.tdd.java;

import org.javamoney.moneta.Money;

public class OrderItem {
    private String sku;
    private Money price;

    OrderItem(String sku, Money price) {

        this.sku = sku;
        this.price = price;
    }

    public String getSku() {
        return sku;
    }

    public void setSku(String sku) {
        this.sku = sku;
    }

    public Money getPrice() {
        return price;
    }

    public void setPrice(Money price) {
        this.price = price;
    }
}
