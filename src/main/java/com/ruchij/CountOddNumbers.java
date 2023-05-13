package com.ruchij;

public class CountOddNumbers {
    public int countOdds(int low, int high) {
        int lower = low % 2 == 1 ? low - 1 : low;
        int higher = high % 2 == 1 ? high + 1 : high;

        return (higher - lower) / 2;
    }
}
