package com.laribee.tdd.java;

import org.junit.Test;
import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertTrue;

public class StoreTests {

    @Test
    public void Submit_the_new_order_to_the_database() {
        // Arrange
        FakeDatabase fakeDatabase = new FakeDatabase();
        Store subject = new Store(fakeDatabase);
        NewOrderMessage newOrderMessage = new NewOrderMessage();

        // Act
        subject.create(newOrderMessage);

        // Assert
        assertTrue(fakeDatabase.saveWasCalled());
    }

    @Test
    public void Map_the_new_order_message_to_the_newly_created_order() {
        // Arrange
        FakeDatabase fakeDatabase = new FakeDatabase();
        Store subject = new Store(fakeDatabase);
        NewOrderMessage newOrderMessage = new NewOrderMessage();
        newOrderMessage.addProduct("APPLIANCES", "InstaPot", 53.18, "All in one cooker!");

        // Act
        subject.create(newOrderMessage);

        // Assert
        assertEquals(1, fakeDatabase.getLastCreatedOrder().getItems().size());
    }
}
