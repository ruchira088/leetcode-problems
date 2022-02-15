package com.ruchij;

import org.junit.jupiter.api.Test;

class TilePossibilitiesTest {
    private final TilePossibilities tilePossibilities = new TilePossibilities();

    @Test
    void testOne() {
        System.out.println(tilePossibilities.possibilities("1234"));
    }

}