package com.ruchij;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class FirstBadVersionTest {

    @Test
    void testOne() {
        for (int i = 1; i < 10; i++) {
            FirstBadVersion firstBadVersion = new FirstBadVersion(i);
            Assertions.assertEquals(i, firstBadVersion.firstBadVersion(10));
        }

    }

}