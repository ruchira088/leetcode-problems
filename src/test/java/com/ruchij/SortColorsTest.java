package com.ruchij;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class SortColorsTest {
    private static final SortColors sortColors = new SortColors();

    @Test
    void shouldSortColors() {
        int[] input = new int[]{1,0, 2, 3, 1};
        sortColors.sortColors(input);

        assertArrayEquals(new int[] {0, 1, 1, 2, 3}, input);

        input = new int[]{1};
        sortColors.sortColors(input);

        assertArrayEquals(new int[] {1}, input);

        input = new int[]{1, 0, 0, 1, 3, 2, 4, 5, 3, 1, 0, 2};
        sortColors.sortColors(input);

        assertArrayEquals(new int[] {0, 0, 0, 1, 1, 1, 2, 2, 3, 3, 4, 5}, input);

        input = new int[]{9, 8, 7, 6, 5, 4, 3, 2, 1, 0};
        sortColors.sortColors(input);

        assertArrayEquals(new int[] {0, 1, 2, 3, 4, 5, 6, 7, 8, 9}, input);

        for (int i = 0; i < 10000; i++) {
            int[] array = new Random().ints(0, 1_000_000).limit(100).toArray();
            int[] expected = new int[100];
            System.arraycopy(array, 0, expected, 0, array.length);
            Arrays.sort(expected);
            sortColors.sortColors(array);
            assertArrayEquals(expected, array);
        }
    }
}