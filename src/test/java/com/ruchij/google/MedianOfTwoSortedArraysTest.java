package com.ruchij.google;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MedianOfTwoSortedArraysTest {
    private static final MedianOfTwoSortedArrays medianOfTwoSortedArrays = new MedianOfTwoSortedArrays();

    @Test
    void verifyResults() {
        assertEquals(2, medianOfTwoSortedArrays.findMedianSortedArrays(new int[]{1, 3}, new int[]{2}));
        assertEquals(2.5, medianOfTwoSortedArrays.findMedianSortedArrays(new int[]{1, 2}, new int[]{3, 4}));
        assertEquals(2, medianOfTwoSortedArrays.findMedianSortedArrays(new int[]{2}, new int[]{}));
        assertEquals(-1, medianOfTwoSortedArrays.findMedianSortedArrays(new int[]{3}, new int[]{-2, -1}));
        assertEquals(8, medianOfTwoSortedArrays.findMedianSortedArrays(new int[]{1, 3, 4, 8, 8, 10}, new int[]{2, 5, 7, 8, 9, 9, 9}));
        assertEquals(2.5, medianOfTwoSortedArrays.findMedianSortedArrays(new int[]{2, 3, 4}, new int[]{1}));

    }


}