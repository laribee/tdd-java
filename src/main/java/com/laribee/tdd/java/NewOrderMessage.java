package com.laribee.tdd.java;

import java.util.Collections;
import java.util.Date;
import java.util.List;

public class NewOrderMessage {

    private Date createdAt;
    private List<Sku> items;
    private String customer;

    public NewOrderMessage(String customer, List<Sku> items) {
        this.customer = customer;
        this.items = items;
    }

    public Date getCreatedAt() {
        return this.createdAt;
    }

    public String getCustomer() {
        return this.customer;
    }

    public List<Sku> getItems() {
        return Collections.unmodifiableList(this.items);
    }
}
