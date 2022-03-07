package com.ruchij;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class AmazonCodeTest {

    @Test
    void testOne() {
        assertEquals(8, AmazonCode.maximumQuality(new ArrayList<>(List.of(1, 2, 3, 4, 5)), 2));
    }

    @Test
    void testTwo() {
        assertEquals(3, AmazonCode.findTotalImbalance(List.of(4, 1, 3, 2)));
        assertEquals(1, AmazonCode.findTotalImbalance(List.of(3, 1, 2)));
        assertEquals(7, AmazonCode.findTotalImbalance(List.of(2, 1, 5, 3, 4)));


    }

}