package com.ruchij;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class MinimumParenthesisRemovedTest {
    private final MinimumParenthesisRemoved minimumParenthesisRemoved = new MinimumParenthesisRemoved();

    @Test
    void testOne() {
        Assertions.assertEquals("lee(t(c)o)de", minimumParenthesisRemoved.minRemoveToMakeValid("lee(t(c)o)de)"));
    }

    @Test
    void testTwo() {
        Assertions.assertEquals("lee(t(c)o)de", minimumParenthesisRemoved.minRemoveToMakeValid("lee(t(c)(o)de"));
    }

}