package com.laribee.tdd.java;

import org.javamoney.moneta.Money;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

// There's a plugin for that: BuilderGenerator
public class OrderBuilder {

    List<OrderCommand> commands = new ArrayList<>();

    public OrderBuilder withElectronicsItems(BigDecimal price) {
        AddItemToOrder command = new AddItemToOrder();
        command.dollars = price;
        command.itemType = "ELECTRONICS";
        commands.add(command);
        return this;
    }

    public OrderBuilder withAppliances(BigDecimal bigDecimal) {
        AddItemToOrder command = new AddItemToOrder();
        command.dollars = bigDecimal;
        command.itemType = "APPLIANCES";
        commands.add(command);
        return this;
    }

    public Order toOrder() {
        Order newOrder = new Order(new OrderParams("dave@devjam.com"));
        for(OrderCommand command : commands) {
            command.transform(newOrder);
        }
        return newOrder;
    }

    public OrderBuilder repeat(int times) {
        OrderCommand lastCommand = commands.get(commands.size());
        commands.add(lastCommand);
        return this;
    }

    public OrderBuilder twice() {
        repeat(2);
        return this;
    }

    interface OrderCommand {
        void transform(Order order);
    }

    class AddItemToOrder implements OrderCommand {

        BigDecimal dollars;
        String itemType;

        @Override
        public void transform(Order order) {
            dollars = BigDecimal.valueOf(100.0);
            order.addItem(new Sku(itemType, 1, Money.of(dollars, "USD")));
        }
    }
}
