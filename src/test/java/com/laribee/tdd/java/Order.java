package com.laribee.tdd.java;

import java.util.ArrayList;
import java.util.List;
public class Order implements Voidable {

    private ArrayList<OrderItem> items = new ArrayList<>();
    private boolean voided = false;

    public List<OrderItem> getItems() {
        return items;
    }

    public void addItem(OrderItem item) {
        if (voided) return;
        items.add(item);
    }

    public double getTotal() {
        double sumTotal = 0.0;
        for (OrderItem item : items) {
            if (item.isVoided()) continue;
            sumTotal += item.getPrice();
        }
        return sumTotal;
    }

    @Override
    public void makeVoid() {
        voided = true;
        makeAllItemsVoided();
    }

    private void makeAllItemsVoided() {
        for (OrderItem item: items) {
            item.makeVoid();
        }
    }

    @Override
    public boolean isVoided() {
        return voided;
    }
}
