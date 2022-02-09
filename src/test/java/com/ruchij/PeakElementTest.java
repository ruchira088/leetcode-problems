package com.ruchij;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class PeakElementTest {
    private final PeakElement peakElement = new PeakElement();

    @Test
    void testOne() {
        int peakElement = this.peakElement.findPeakElement(new int[]{1, 2, 3, 1});
        Assertions.assertEquals(2, peakElement);
    }

    @Test
    void testTwo() {
        int peakElement = this.peakElement.findPeakElement(new int[]{1, 2, 1, 3, 5, 6, 4});
        Assertions.assertEquals(5, peakElement);
    }

    @Test
    void testThree() {
        int peakElement = this.peakElement.findPeakElement(new int[]{3, 4, 3, 2, 1});
        Assertions.assertEquals(1, peakElement);
    }

}