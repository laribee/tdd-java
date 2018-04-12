package com.laribee.tdd.java;
import org.javamoney.moneta.Money;

public class Sku {

    private String sku;
    private int quantity;
    private Money price;

    Sku(String sku, int quantity, Money price) {
        this.sku = sku;

        this.quantity = quantity;
        this.price = price;
    }

    public String getSku() {
        return sku;
    }

    public int getQuantity() {
        return quantity;
    }

    public Money getPrice() {
        return price;
    }
}
