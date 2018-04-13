package com.laribee.tdd.java;

import org.junit.Before;
import org.junit.Test;
import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertFalse;
import static junit.framework.TestCase.assertNotNull;
import static org.junit.Assert.assertTrue;

public class OrderItemTests {

    @Test
    public void Verify_order_exists() {
        OrderItem subject = createDefaultTestableOrderItem();
    }

    @Test
    public void Verify_order_has_key_properties() {
        OrderItem subject = createDefaultTestableOrderItem();
        assertEquals(53.12, subject.getPrice());
        assertEquals("ELECTRONICS", subject.getType());
        assertEquals("Sony Walkman", subject.getDescription());
        assertEquals("", subject.getSku());
    }

    private OrderItem createDefaultTestableOrderItem() {
        NewOrderItemDTO dto  = new NewOrderItemDTO();
        dto.setPrice(53.12);
        dto.setSku("");
        dto.setDescription("Sony Walkman");
        dto.setType("ELECTRONICS");
        return new OrderItem(dto);
    }

    @Test
    public void Set_initial_price_on_order_item() {
        OrderItem subject = createDefaultTestableOrderItem();
        assertEquals(53.12, subject.getPrice());
    }

    @Test
    public void Set_type_on_order_item_when_creating() {
        OrderItem subject = createDefaultTestableOrderItem();
        assertEquals("ELECTRONICS", subject.getType());
    }

    @Test
    public void new_order_items_are_in_an_unvoided_state() {
        OrderItem subject = createDefaultTestableOrderItem();
        assertFalse(subject.isVoided());
    }
    
    @Test
    public void order_items_can_be_voided() {
        OrderItem subject = createDefaultTestableOrderItem();

        subject.makeVoid();

        assertTrue(subject.isVoided());
    }


    @Test
    public void Set_description_on_order_item_when_creating() {
        OrderItem subject = createDefaultTestableOrderItem();
        assertEquals("Sony Walkman", subject.getDescription());
    }

    @Test
    public void If_an_order_item_is_not_electronics_or_appliances_then_it_becomes_miscellaneous() {

        //Arrange
        NewOrderItemDTO dto  = new NewOrderItemDTO();
        dto.setPrice(53.12);
        dto.setSku("");
        dto.setDescription("Toro");
        dto.setType("Lawn Mower");

        NewOrderItemDTO electronicsDto = getNewOrderItemDTO();

        NewOrderItemDTO applianceDto  = new NewOrderItemDTO();
        applianceDto.setPrice(53.12);
        applianceDto.setSku("InstaPot");
        applianceDto.setDescription("InstaPot");
        applianceDto.setType("APPLIANCES");

        // Act
        OrderItem subject = new OrderItem(dto);
        OrderItem electronicsSubject = new OrderItem(electronicsDto);
        OrderItem applianceSubject = new OrderItem(applianceDto);

        // Assert
        assertEquals("MISCELLANEOUS", subject.getType());
        assertEquals("ELECTRONICS", electronicsSubject.getType());
        assertEquals("APPLIANCES", applianceSubject.getType());
    }

    private NewOrderItemDTO getNewOrderItemDTO() {
        NewOrderItemDTO electronicsDto  = new NewOrderItemDTO();
        electronicsDto.setPrice(1003.12);
        electronicsDto.setSku("");
        electronicsDto.setDescription("iPhone");
        electronicsDto.setType("ELECTRONICS");
        return electronicsDto;
    }

    @Test
    public void Price_cannot_be_negative() {
        NewOrderItemDTO dto  = new NewOrderItemDTO();
        dto.setPrice(-100.0);
        dto.setSku("");
        dto.setDescription("Toro");
        dto.setType("Lawn Mower");

        OrderItem subject = new OrderItem(dto);

        assertEquals(0.0, subject.getPrice());
    }

    @Test(expected = NullPointerException.class)
    public void order_item_property_sku_cannot_be_not_null() {
        NewOrderItemDTO dto  = new NewOrderItemDTO();
        dto.setPrice(34.0);
        dto.setSku(null);
        dto.setDescription("Toro");
        dto.setType("Lawn Mower");

        OrderItem subject = new OrderItem(dto);

    }


    @Test(expected = NullPointerException.class)
    public void order_item_property_description_cannot_be_not_null() {
        NewOrderItemDTO dto  = new NewOrderItemDTO();
        dto.setPrice(34.0);
        dto.setSku("");
        dto.setDescription(null);
        dto.setType("Lawn Mower");

        OrderItem subject = new OrderItem(dto);

    }

    @Test(expected = NullPointerException.class)
    public void order_item_property_type_cannot_be_not_null() {
        NewOrderItemDTO dto  = new NewOrderItemDTO();
        dto.setPrice(34.0);
        dto.setSku("");
        dto.setDescription("");
        dto.setType(null);

        OrderItem subject = new OrderItem(dto);

    }


}
