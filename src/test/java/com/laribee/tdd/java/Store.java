package com.laribee.tdd.java;

public class Store {

    private Database database;

    public Store(Database database) {

        this.database = database;
    }

    public long create(OrderPayload orderPayload) {
        Order order = new Order();
        order.customerId = orderPayload.customerId;
        return database.save(order);
    }

    public Order find(int orderId) {
        return(this.database.find(orderId));
    }
}
