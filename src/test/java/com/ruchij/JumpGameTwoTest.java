package com.ruchij;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class JumpGameTwoTest {
    private final JumpGameTwo jumpGameTwo = new JumpGameTwo();

    @Test
    void testOne() {
        int[] input = {2, 3, 1, 1, 4};
        assertEquals(2, jumpGameTwo.jump(input));
    }

    @Test
    void testTwo() {
        int[] input = {2, 3, 0, 1, 4};
        assertEquals(2, jumpGameTwo.jump(input));
    }

}