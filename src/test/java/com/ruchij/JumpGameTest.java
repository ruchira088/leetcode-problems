package com.ruchij;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class JumpGameTest {
    private static final JumpGame jumpGame = new JumpGame();

    @Test
    void expectedResult() {
        Assertions.assertTrue(jumpGame.canJump(new int[]{2, 3, 1, 1, 4}));
        Assertions.assertFalse(jumpGame.canJump(new int[]{3, 2, 1, 0, 4}));
//
//        int[] input = new int[10000];
//
//        for (int i = 0; i < 10000; i++) {
//            input[i] = 9999 - i;
//        }
//
//        Assertions.assertTrue(jumpGame.canJump(input));


    }

}