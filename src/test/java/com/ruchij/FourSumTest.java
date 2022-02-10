package com.ruchij;

import org.junit.jupiter.api.Test;

import java.util.List;

class FourSumTest {
    private final FourSum fourSum = new FourSum();

    @Test
    void testOne() {
        List<List<Integer>> result = fourSum.fourSum(new int[]{1, 0, -1, 0, -2, 2}, 0);
        System.out.println(result);
    }

    @Test
    void testTwo() {
        List<List<Integer>> result = fourSum.fourSum(new int[]{2, 2, 2, 2, 2}, 8);
        System.out.println(result);
    }

    @Test
    void testThree() {
        List<List<Integer>> result = fourSum.fourSum(new int[]{10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,20,20,20,20,20,20,20,20,20,20,20,20,20,20,20,20,20,20,20,20,30,30,30,30,30,30,30,30,30,30,30,30,30,30,30,30,30,30,30,30,40,40,40,40,40,40,40,40,40,40,40,40,40,40,40,40,40,40,40,40,50,50,50,50,50,50,50,50,50,50,50,50,50,50,50,50,50,50,50,50,60,60,60,60,60,60,60,60,60,60,60,60,60,60,60,60,60,60,60,60,70,70,70,70,70,70,70,70,70,70,70,70,70,70,70,70,70,70,70,70,80,80,80,80,80,80,80,80,80,80,80,80,80,80,80,80,80,80,80,80,90,90,90,90,90,90,90,90,90,90,90,90,90,90,90,90,90,90,90,90}, 200);
        System.out.println(result);
    }

}