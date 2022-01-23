package com.ruchij;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class TextJustifyTest {
    private final TextJustify textJustify = new TextJustify();

    @Test
    void justifyOne() {
        String[] inputOne = {"This", "is", "an", "example", "of", "text", "justification."};
        List<String> result = textJustify.fullJustify(inputOne, 16);
        List<String> expected = List.of("This    is    an", "example  of text", "justification.  ");

        Assertions.assertEquals(expected, result);
    }
}
