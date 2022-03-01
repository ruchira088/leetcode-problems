package com.ruchij;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class KthLargestElementInArrayTest {
    private final KthLargestElementInArray kthLargestElementInArray = new KthLargestElementInArray();

    @Test
    void testOne() {
        assertEquals(5, kthLargestElementInArray.findKthLargest(new int[]{3, 2, 1, 5, 6, 4}, 2));
    }

    @Test
    void testTwo() {
        assertEquals(4, kthLargestElementInArray.findKthLargest(new int[]{3,2,3,1,2,4,5,5,6}, 4));
    }

}