package com.laribee.tdd.java;

public class Store {

    private Database database;

    public Store(Database database) {

        this.database = database;
    }

    public void create(NewOrderMessage newOrderMessage) {

        Order order = new Order();

        // Mapping
        NewOrderItemDTO dto = new NewOrderItemDTO();

        dto.setPrice(newOrderMessage.getPrice());
        dto.setType(newOrderMessage.getType());
        dto.setDescription(newOrderMessage.getDescription());
        dto.setSku(newOrderMessage.setSku());

        order.addItem(new OrderItem(dto));
        database.save(order);

    }
}
