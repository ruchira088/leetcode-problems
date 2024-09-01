package com.ruchij.google;

public class MedianOfTwoSortedArrays {
    public double findMedianSortedArrays(int[] xs, int[] ys) {
        if (ys.length < xs.length) {
            return findMedianSortedArrays(ys, xs);
        }

        int x = xs.length;
        int y = ys.length;

        int low = 0;
        int high = x;

        while (low <= high) {
            int partitionX = (low + high) / 2;
            int partitionY = (x + y + 1) / 2 - partitionX;

            int leftX = partitionX == 0 ? Integer.MIN_VALUE : xs[partitionX - 1];
            int rightX = partitionX == x ? Integer.MAX_VALUE : xs[partitionX];

            int leftY = partitionY == 0 ? Integer.MIN_VALUE : ys[partitionY - 1];
            int rightY = partitionY == y ? Integer.MAX_VALUE : ys[partitionY];

            if (leftX <= rightY && leftY <= rightX) {
                int leftMax = Math.max(leftY, leftX);

                if ((x + y) % 2 == 1) {
                    return leftMax;
                } else {
                    return ((double) (leftMax + Math.min(rightX, rightY))) / 2;
                }
            } else if (leftX > rightY) {
                high = partitionX - 1;
            } else {
                low = partitionX + 1;
            }
        }


        throw new IllegalArgumentException("Input arrays are not sorted");
    }
}
