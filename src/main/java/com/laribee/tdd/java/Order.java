package com.laribee.tdd.java;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Order {

    private ArrayList<OrderItem> items = new ArrayList<>();
    private String customer;
    public int customerId;

    Order() {

    }

    Order(OrderParams orderParams) {
        this.customer = orderParams.getCustomer();
    }

    public List<OrderItem> getItems() {
        return Collections.unmodifiableList(items);
    }

    public void addItem(Sku item) {
        for(int index = 0; index < item.getQuantity(); index++) {
            items.add(new OrderItem(item.getSku(), item.getPrice()));
        }
    }

    public String getCustomerEmail() {
        return customer;
    }
}
