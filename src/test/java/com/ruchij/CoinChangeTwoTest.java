package com.ruchij;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class CoinChangeTwoTest {
    @Test
    void coinChange() {
        CoinChangeTwo coinChange = new CoinChangeTwo();

        int[] inputOne = {1, 2, 5};
        Assertions.assertEquals(3, coinChange.coinChange(inputOne, 11));

        int[] inputTwo = {2};
        Assertions.assertEquals(-1, coinChange.coinChange(inputTwo, 3));

        int[] inputThree = {2, 5};
        Assertions.assertEquals(3, coinChange.coinChange(inputThree, 6));

        int[] inputFour = {1, 2, 5};
        Assertions.assertEquals(20, coinChange.coinChange(inputFour, 100));
    }

}