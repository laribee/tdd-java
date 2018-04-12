package com.laribee.tdd.java;

import java.util.ArrayList;
import java.util.List;
import org.javamoney.moneta.Money;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.is;

import org.junit.Test;

import static org.mockito.Mockito.*;


import org.mockito.ArgumentCaptor;

public class OrderControllerTests {

    @Test
    public void testSaveOrdertoDb() {
        Database database = mock(Database.class);
        OrderController orderController = new OrderController(database);

        //action
        orderController.create(new OrderPayload(42));

        //assertion
        verify(database).save(any(Order.class));
    }

    @Test
    public void mapThePayloadToTheOrderBusinessObject() {
        Database database = mock(Database.class);
        OrderController subject = new OrderController(database);

        ArgumentCaptor<Order> captor = ArgumentCaptor.forClass(Order.class);

        subject.create(new OrderPayload(42));

        verify(database).save(captor.capture());

        assertEquals(42, captor.getValue().customerId);

    }

    @Test
    public void testReturnIdToClient() {
        Database database = mock(Database.class);
        OrderController subject = new OrderController(database);

        when(database.save(any(Order.class))).thenReturn((long) 13);
        long orderId = subject.create(new OrderPayload(43));
    }

    @Test
    public void testReturnOrderFromDatabase(){
        Database database = mock(Database.class);
        OrderController subject = new OrderController(database);

        //action
        subject.find(42);

        //assertion
        verify(database).find(42);
    }

    @Test public void testReturnOrderToClient() {
        Database database = mock(Database.class);
        OrderController subject = new OrderController(database);

        Order returnedOrder = new Order();
        when(database.find(42)).thenReturn(returnedOrder);

        Order order = subject.find(42);

        assertEquals(returnedOrder, order);

    }
    
}