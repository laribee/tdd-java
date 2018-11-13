package com.laribee.tdd.java;

import org.junit.Assert;
import org.junit.Test;

public class FibonacciTests {

    @Test public void first_number_is_zero() {
        int result = generateFibonacciSequence(1)[0];
        Assert.assertEquals(0, result);
    }


    private int[] generateFibonacciSequence(int lengthOfSequence) {
        int[] result = new int[1];
        result[0] = 0;
        return result;
    }
}
