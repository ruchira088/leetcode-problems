package com.ruchij;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class AmazonFreshPromoTest {

    @Test
    void testOne() {
        List<String> codes = List.of("apple apple", "banana anything banana");
        List<String> shoppingCart = List.of("apple", "apple", "banana", "banana", "banana");
    }

    @Test
    void testTwo() {
        List<String> codes = List.of("apple apple", "banana anything banana");
        List<String> shoppingCart = List.of("apple", "apple", "apple", "banana", "banana");

        assertEquals(0, AmazonFreshPromo.foo(codes, shoppingCart));
    }

    @Test
    void testThree() {
        List<String> codes = List.of("apple apple", "banana anything banana");
        List<String> shoppingCart = List.of("orange", "apple", "apple", "banana", "orange", "banana");
    }

}