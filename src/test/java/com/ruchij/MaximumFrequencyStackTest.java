package com.ruchij;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class MaximumFrequencyStackTest {

    @Test
    void testOne() {
        MaximumFrequencyStack.FreqStack freqStack = new MaximumFrequencyStack.FreqStack();
        freqStack.push(5);
        freqStack.push(7);
        freqStack.push(5);
        freqStack.push(7);
        freqStack.push(4);
        freqStack.push(5);

        Assertions.assertEquals(5, freqStack.pop());
        Assertions.assertEquals(7, freqStack.pop());
        Assertions.assertEquals(5, freqStack.pop());
        Assertions.assertEquals(4, freqStack.pop());
    }

}