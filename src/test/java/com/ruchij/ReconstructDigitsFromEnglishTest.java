package com.ruchij;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class ReconstructDigitsFromEnglishTest {
    private final ReconstructDigitsFromEnglish reconstructDigitsFromEnglish = new ReconstructDigitsFromEnglish();

    @Test
    void testOne() {
        Assertions.assertEquals("012", reconstructDigitsFromEnglish.originalDigits("owoztneoer"));
    }

    @Test
    void testTwo() {
        Assertions.assertEquals("45", reconstructDigitsFromEnglish.originalDigits("fviefuro"));
    }

}