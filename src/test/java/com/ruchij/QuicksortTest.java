package com.ruchij;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class QuicksortTest {
    private final Quicksort quicksort = new Quicksort();

    @Test
    void testOne() {
        Assertions.assertEquals(List.of(1, 2, 3, 4, 5), quicksort.sort(new ArrayList<>(List.of(3, 2, 4, 1, 5))));

        System.out.println(Arrays.stream(quicksort.sort(new int[] {3, 2, 4, 1, 9, 6, 0, 1, 1})).boxed().toList());
    }

}