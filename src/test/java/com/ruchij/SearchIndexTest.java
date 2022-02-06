package com.ruchij;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class SearchIndexTest {
    private final SearchIndex searchIndex = new SearchIndex();

    @Test
    void testOne() {
        int result = searchIndex.searchInsert(new int[]{1, 3, 5, 7, 9}, 2);
        Assertions.assertEquals(1, result);
    }

    @Test
    void testTwo() {
        int result = searchIndex.searchInsert(new int[]{1, 3, 5, 7, 9}, 1);
        Assertions.assertEquals(0, result);
    }

    @Test
    void testThree() {
        int result = searchIndex.searchInsert(new int[]{1, 3, 5, 7, 9}, 10);
        Assertions.assertEquals(5, result);
    }

}