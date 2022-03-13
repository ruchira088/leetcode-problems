package com.ruchij;

public class RotateImage {
//    public void rotate(int[][] matrix) {
//        int n = matrix.length;
//
//        for (int i = 0; i < (n + 1) / 2; i++) {
//            for (int j = 0; j < n / 2; j++) {
//                int temp = matrix[j][n - 1 - i];
//                matrix[j][n - 1 - i] = matrix[i][j];
//                matrix[i][j] = matrix[n - j - 1][i];
//                matrix[n - j - 1][i] = matrix[n - i - 1][n - j - 1];
//                matrix[n - i - 1][n - j - 1] = temp;
//            }
//        }
//    }

    public void rotate(int[][] matrix) {
        int n = matrix.length;

        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                int temp = matrix[j][i];
                matrix[j][i] = matrix[i][j];
                matrix[i][j] = temp;
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n / 2; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[i][n - j - 1];
                matrix[i][n - j - 1] = temp;
            }
        }

    }

    void print(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            StringBuilder stringBuilder = new StringBuilder();
            for (int j = 0; j < matrix[i].length; j++) {
                stringBuilder.append(matrix[i][j]);
                stringBuilder.append("\t");
            }

            System.out.println(stringBuilder);
        }
    }
}
