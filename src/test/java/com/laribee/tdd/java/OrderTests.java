package com.laribee.tdd.java;

import org.javamoney.moneta.Money;
import org.junit.Test;
import java.math.BigDecimal;
import static org.junit.Assert.*;

public class OrderTests {

    @Test
    public void an_order_can_have_zero_items() {
        Order subject = new Order(new OrderParams(""));

        assertEquals(0, subject.getItems().size());
    }

    @Test
    public void an_order_can_multiple_items() {

        Order subject = new Order(new OrderParams(""));

        Sku sku1 = new Sku("ELECTRONICS", 3, Money.of(99, "USD"));
        Sku sku2 = new Sku("APPLIANCE", 1, Money.of(300, "USD"));

        subject.addItem(sku1);
        subject.addItem(sku2);

        assertEquals(4, subject.getItems().size());

    }

    @Test
    public void two_electronics_items_gives_a_discount_of_10_percent_on_highest_priced_item() {

        Order subject = newOrder()
                            .withElectronicsItems(BigDecimal.valueOf(100))
                            .twice()
                            .toOrder();


    }

    private OrderBuilder newOrder() {
        return new OrderBuilder();
    }

}
