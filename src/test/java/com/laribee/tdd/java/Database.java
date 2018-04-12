package com.laribee.tdd.java;

public interface Database {
    long save(Order order);

    Order find(int i);
}
