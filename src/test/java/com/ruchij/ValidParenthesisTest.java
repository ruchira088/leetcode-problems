package com.ruchij;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class ValidParenthesisTest {
    private final ValidParenthesis validParenthesis = new ValidParenthesis();

    @Test
    void testOne() {
        Assertions.assertTrue(validParenthesis.isValid("()"));
    }

}