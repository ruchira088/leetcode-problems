package com.ruchij.canva;

import java.util.Arrays;

public class ShippingPackages {
    public int shipWithinDays(int[] weights, int days) {
        int left = Arrays.stream(weights).max().getAsInt();
        int right = Arrays.stream(weights).sum();

        while (left <= right) {
            int mid = (left + right) / 2;

            if (canShip(weights, days, mid)) {
                if (right == mid) {
                    return mid;
                }

                right = mid;
            } else {
                if (left == mid) {
                    return right;
                }

                left = mid;
            }
        }

        return left;
    }

    private boolean canShip(int[] weights, int daysLimit, int size) {
        int days = 1;
        int ship = 0;

        for (int weight : weights) {
            if (ship + weight <= size) {
                ship = ship + weight;
            } else {
                days++;
                ship = weight;
            }

            if (days > daysLimit) {
                return false;
            }
        }

        return true;
    }
}
