package com.laribee.tdd.java;

public class FakeDatabase implements Database {

    private boolean saveWasCalled;
    private Order lastOrderCreated;

    public boolean saveWasCalled() {
        return saveWasCalled;
    }

    @Override
    public void save(Order order) {
        lastOrderCreated = order;
        saveWasCalled = true;
    }

    public Order getLastCreatedOrder() {
        return lastOrderCreated;
    }
}
