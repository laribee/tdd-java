package com.laribee.tdd.java;

import org.junit.Test;
import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertFalse;

public class OrderTests {

    @Test
    public void After_an_order_is_created_it_has_zero_items() {
        Order subject = new Order();
        assertEquals(0, subject.getItems().size());
    }

    @Test
    public void You_can_add_several_items_to_an_order() {
        Order subject = new Order();
        subject.addItem(createRandoOrderItem());
        subject.addItem(createRandoOrderItem());
        subject.addItem(createRandoOrderItem());
        assertEquals(3, subject.getItems().size());
    }

    @Test
    public void verify_that_a_new_order_has_a_zero_total(){
        Order subject = new Order();
        assertEquals(0.0, subject.getTotal());
    }

    @Test
    public void the_order_total_equals_the_sum_of_all_items_added_to_it() {
        Order order = new Order();
        OrderItem item1 = createAppliance(42.11);
        OrderItem item2 = createAppliance(19.95);

        order.addItem(item1);
        order.addItem(item2);

        assertEquals(62.06, order.getTotal());
    }

    @Test
    public void the_order_can_be_marked_void() {
        Voidable order = new Order();
        order.makeVoid();
        assertTrue(order.isVoided());
    }
    
    @Test
    public void an_order_with_a_single_item_can_have_that_item_voided_without_voiding_the_entire_order() {
        Order order = new Order();
        OrderItem appliance = createAppliance(42.99);
        order.addItem(appliance);

        appliance.makeVoid();

        assertFalse(order.isVoided());
    }

    @Test
    public void ensure_that_a_voided_order_item_does_not_participate_in_the_order_total() {
        Order order = createOrderWithTwoItemsWhereOneIsVoided(99.99);

        assertEquals(99.99, order.getTotal());
    }

    private Order createOrderWithTwoItemsWhereOneIsVoided(double price) {
        Order order = new Order();
        order.addItem(createAppliance(price));
        OrderItem voidedOrderItem = createAppliance(price);
        order.addItem(voidedOrderItem);

        voidedOrderItem.makeVoid();
        return order;
    }

    @Test
    public void additional_items_can_be_added_to_an_order_with_a_voided_item() {
        Order order = createOrderWithTwoItemsWhereOneIsVoided(100.0);

        order.addItem(createAppliance(142.94));

        assertEquals(3, order.getItems().size());
        assertEquals(242.94, order.getTotal());
    }

    private OrderItem createAppliance(double price) {
        NewOrderItemDTO dto = new NewOrderItemDTO();
        dto.setDescription("Blender");
        dto.setSku("VITAMIX");
        dto.setType("APPLIANCE");
        dto.setPrice(price);
        return new OrderItem(dto);
    }

    private OrderItem createRandoOrderItem() {
        NewOrderItemDTO dto = new NewOrderItemDTO();
        dto.setPrice(11.11);
        dto.setDescription("Sony Walkman");
        dto.setSku("SONY_WALKMAN");
        dto.setType("Electronics");
        return new OrderItem(dto);
    }

    @Test
    public void ensure_voided_order_total_is_zero() {
        Order testOrder = new Order();
        testOrder.addItem(createAppliance(11.11));

        testOrder.makeVoid();

        assertEquals(0.0, testOrder.getTotal());
    }

    @Test
    public void ensure_order_is_not_voided_when_only_item_is_voided() {
        Order testOrder = new Order();
        OrderItem appliance = createAppliance(11.11);
        testOrder.addItem(appliance);

        appliance.makeVoid();

        assertFalse(testOrder.isVoided());
    }

    @Test
    public void ensure_voided_order_does_not_allow_order_item_to_be_added() {
        Order testOrder = new Order();

        testOrder.makeVoid();

        OrderItem appliance = createAppliance(11.11);
        testOrder.addItem(appliance);

        assertEquals(0, testOrder.getItems().size());
    }

}
