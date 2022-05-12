package com.ruchij;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MinAddToMakeValidTest {

    private final MinAddToMakeValid minAddToMakeValid = new MinAddToMakeValid();

    @Test
    void testOne() {
        assertEquals(1, minAddToMakeValid.minAddToMakeValid("())"));
        assertEquals(3, minAddToMakeValid.minAddToMakeValid("((("));
    }

}