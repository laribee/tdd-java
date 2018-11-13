package com.laribee.tdd.java;

import java.util.ArrayList;
import java.util.List;
import org.junit.Assert;
import org.junit.Test;
import static org.junit.Assert.*;

public class FibonacciTests {

    @Test public void It_works() {
        List<Integer> foo = generateFibonacciSequence(8);

        Assert.assertEquals(0, (int)foo.get(0));
        Assert.assertEquals(1, (int)foo.get(1));
        Assert.assertEquals(1, (int)foo.get(2));
        Assert.assertEquals(2, (int)foo.get(3));
        Assert.assertEquals(3, (int)foo.get(4));
        Assert.assertEquals(5, (int)foo.get(5));
        Assert.assertEquals(8, (int)foo.get(6));
        Assert.assertEquals(13, (int)foo.get(7));
    }

    // Sweet Fibonacci "algorithm"
    private List<Integer> generateFibonacciSequence(int lengthOfSequence) {
        List<Integer> result = new ArrayList<>();

        for (int i = 0; i < lengthOfSequence; i++) {

            if (i == 0) {
                result.add(0);
                continue;
            }

            if ((i == 1)||( i == 2)) {
                result.add(1);
                continue;
            }

            result.add(result.get(i-1) + result.get(i-2));
        }

        return result;
    }
}
