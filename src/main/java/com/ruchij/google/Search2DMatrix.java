package com.ruchij.google;

public class Search2DMatrix {
    public boolean searchMatrix(int[][] matrix, int target) {
        int width = matrix[0].length;
        int height = matrix.length;

        int left = 0;
        int right = height * width - 1;

        while (left <= right) {
            int midPoint = (left + right) / 2;

            int y = midPoint / width;
            int x = midPoint % width;

            int value = matrix[y][x];

            if (value == target) {
                return true;
            } else if (value > target) {
                right = midPoint - 1;
            } else {
                left = midPoint + 1;
            }
        }

        return false;
    }


}
