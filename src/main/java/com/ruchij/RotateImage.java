package com.ruchij;

public class RotateImage {
    public void rotate(int[][] matrix) {
        for (int y = 0; y < matrix.length; y++) {
            for (int x = y + 1; x < matrix[y].length; x++) {
                int temp = matrix[y][x];
                matrix[y][x] = matrix[x][y];
                matrix[x][y] = temp;
            }
        }

        for (int y = 0; y < matrix.length; y++) {
            for (int x = 0; x < matrix[y].length / 2; x++) {
                int temp = matrix[y][x];
                matrix[y][x] = matrix[y][matrix[y].length - 1 - x];
                matrix[y][matrix[y].length - 1 - x] = temp;
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
