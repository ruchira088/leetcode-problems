package com.ruchij;

public class ArrangeCoins {
    public int arrangeCoins(int n) {
        int stairs = 0;
        int remainingCoins = n;

        while (remainingCoins > stairs) {
            stairs++;
            remainingCoins = remainingCoins - stairs;
        }

        return stairs;
    }
}
