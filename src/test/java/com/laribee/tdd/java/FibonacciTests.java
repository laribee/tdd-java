package com.laribee.tdd.java;

import org.junit.Assert;
import org.junit.Test;
import static org.junit.Assert.*;

public class FibonacciTests {

    @Test public void first_number_is_zero() {
        int result = getElementAt(1);
        Assert.assertEquals(0, result);
    }

    @Test public void second_number_is_one() {
        int result = getElementAt(2);
        Assert.assertEquals(1, result);
    }

    @Test public void third_number_is_also_one() {
        int result = getElementAt(3);
        Assert.assertEquals(1, result);
    }

    @Test public void forth_number_is_two() {
        int result = getElementAt(4);
        Assert.assertEquals(2, result);
    }

    @Test public void fifth_number_is_three() {
        int result = getElementAt(5);
        Assert.assertEquals(3, result);
    }

    @Test public void sixth_number_is_five() {
        int result = getElementAt(6);
        Assert.assertEquals(5, result);
    }

    @Test public void seventh_number_is_eight() {
        int result = getElementAt(7);
        Assert.assertEquals(8, result);
    }

    // Test Helper Method
    private int getElementAt(int i) {
        int i2 = i-1;
        return generateFibonacciSequence(i)[i2];
    }

    // Sweet Fibonacci "algorithm"
    private int[] generateFibonacciSequence(int lengthOfSequence) {
        int[] result = new int[lengthOfSequence];
        for (int i = 0; i < lengthOfSequence; i++) {

            if (i == 0) {
                result[i] = i;
                continue;
            }

            if ((i == 1)||( i == 2)) {
                result[i] = 1;
                continue;
            }

            result[i] = result[i-1] + result[i-2];
        }
        return result;
    }
}
