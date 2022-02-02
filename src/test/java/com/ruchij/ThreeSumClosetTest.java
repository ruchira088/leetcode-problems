package com.ruchij;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class ThreeSumClosetTest {
    private final ThreeSumCloset threeSumCloset = new ThreeSumCloset();

    @Test
    void testOne() {
        int[] nums = {-1, 2, 1, -4};
        int target = 1;

        Assertions.assertEquals(2, threeSumCloset.threeSumClosest(nums, target));
    }

    @Test
    void testTwo() {
        int[] nums = {0, 0, 0};
        int target = 1;

        Assertions.assertEquals(0, threeSumCloset.threeSumClosest(nums, target));
    }

    @Test
    void testThree() {
        int[] nums = {1, 1, -1};
        int target = 0;

        Assertions.assertEquals(1, threeSumCloset.threeSumClosest(nums, target));
    }

    @Test
    void testFour() {
        int[] nums = {0, 1, 2};
        int target = 0;

        Assertions.assertEquals(3, threeSumCloset.threeSumClosest(nums, target));
    }

    @Test
    void testFive() {
        int[] nums = {0, 1, 2, -3};
        int target = 1;

        Assertions.assertEquals(0, threeSumCloset.threeSumClosest(nums, target));
    }

}