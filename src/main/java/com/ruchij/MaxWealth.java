package com.ruchij;

import java.util.Arrays;
import java.util.Comparator;

public class MaxWealth {
    public int maximumWealth(int[][] accounts) {
        return Arrays.stream(accounts).map(wealth -> Arrays.stream(wealth).sum()).max(Comparator.comparingInt(x -> x)).get();
    }
}
