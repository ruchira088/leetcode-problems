package com.ruchij.google;

import java.util.function.Function;

public class MedianOfTwoSortedArrays {
    public double myFindMedianSortedArrays(int[] xs, int[] ys) {
        int totalLength = xs.length + ys.length;
        int midPoint = totalLength / 2;

        int indexY = ys.length / 2;

        while (true) {
            int indexX = midPoint - indexY;

            int leftY = indexY == 0 ? Integer.MIN_VALUE : ys[indexY - 1];
            int rightY = indexY == ys.length ? Integer.MAX_VALUE : ys[indexY];

            int leftX = indexX == 0 ? Integer.MIN_VALUE : xs[indexX - 1];
            int rightX = indexX == xs.length ? Integer.MAX_VALUE : xs[indexX];

            if (leftY <= rightX && leftX <= rightY) {
                if (totalLength % 2 == 1) {
                    return Math.min(rightY, rightX);
                } else {
                    return  ((double) (Math.max(leftY, leftX) + Math.min(rightY, rightX))) / 2;
                }
            } else if (leftY > rightX) {
                indexY--;
            } else {
                indexY++;
            }
        }
    }

    public double findMedianSortedArrays(int[] xs, int[] ys) {
        if (ys.length < xs.length) {
            return findMedianSortedArrays(ys, xs);
        }

        int x = xs.length;
        int y = ys.length;

        int low = 0;
        int high = x;

        System.out.println("x + y + 1 = " + (x + y + 1));

        while (low <= high) {
            System.out.println("----------");
            int partitionX = (low + high) / 2;
            int partitionY = (x + y + 1) / 2 - partitionX;

            System.out.println("partitionX=%s, partitionY=%s, low=%s, high=%s".formatted(partitionX, partitionY, low, high));

            int leftX = partitionX == 0 ? Integer.MIN_VALUE : xs[partitionX - 1];
            int rightX = partitionX == x ? Integer.MAX_VALUE : xs[partitionX];

            int leftY = partitionY == 0 ? Integer.MIN_VALUE : ys[partitionY - 1];
            int rightY = partitionY == y ? Integer.MAX_VALUE : ys[partitionY];

            Function<Integer, String> format =
                    integer -> integer == Integer.MAX_VALUE ? "+Inf" : (integer == Integer.MIN_VALUE ? "-Inf" : String.valueOf(integer));

            System.out.println("leftX=%s, rightX=%s".formatted(format.apply(leftX), format.apply(rightX)));
            System.out.println("leftY=%s, rightY=%s".formatted(format.apply(leftY), format.apply(rightY)));

            if (leftX <= rightY && leftY <= rightX) {
                int leftMax = Math.max(leftY, leftX);

                if ((x + y) % 2 == 1) {
                    return leftMax;
                } else {
                    return ((double) (leftMax + Math.min(rightX, rightY))) / 2;
                }
            } else if (leftX > rightY) {
                high = partitionX - 1;
                System.out.println("Decreasing high");
            } else {
                low = partitionX + 1;
                System.out.println("Increasing low");
            }
        }


        throw new IllegalArgumentException("Input arrays are not sorted");
    }
}
