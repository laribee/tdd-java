package com.laribee.tdd.java;

public class OrderController {

    private Database database;

    public OrderController(Database database) {

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
