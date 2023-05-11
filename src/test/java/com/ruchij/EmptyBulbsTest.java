package com.ruchij;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EmptyBulbsTest {

    @Test
    void returnsExpectedResult() {
        EmptyBulbs emptyBulbs = new EmptyBulbs();
        Assertions.assertEquals(2, emptyBulbs.kEmptySlots(new int[] {1, 3, 2}, 1));
        Assertions.assertEquals(-1, emptyBulbs.kEmptySlots(new int[] {1, 2, 3}, 1));
    }

}