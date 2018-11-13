package com.laribee.tdd.java;

public class OrderController {

    private Database database;

    public OrderController(Database database) {

        this.database = database;
    }

    public long create(OrderPayload orderPayload) {
        Order order = new Order();
        order.customerId = orderPayload.customerId;
        return database.persist(order);
    }

    public Order find(int orderId) {
        return(this.database.find(orderId));
    }

    public void markVoid(int orderId) {
        Order order = database.find(orderId);
        order.markVoid();
        database.save(order);
    }
}
