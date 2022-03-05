package com.ruchij;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BuildingsWithOceanViewTest {
    private final BuildingsWithOceanView buildingsWithOceanView = new BuildingsWithOceanView();

    @Test
    void testOne() {
        assertArrayEquals(new int[]{0, 2, 3}, buildingsWithOceanView.findBuildings(new int[]{4, 2, 3, 1}));
    }

    @Test
    void testTwo() {
        assertArrayEquals(new int[]{0, 1, 2, 3}, buildingsWithOceanView.findBuildings(new int[]{4, 3, 2, 1}));
    }

    @Test
    void testThree() {
        assertArrayEquals(new int[]{3}, buildingsWithOceanView.findBuildings(new int[]{1, 3, 2, 4}));
    }

}