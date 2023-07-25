package com.ruchij;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class SingleElementInSortedArrayTest {
    private static final SingleElementInSortedArray singleElementInSortedArray = new SingleElementInSortedArray();

    @Test
    void expectedResult() {
        Assertions.assertEquals(2, singleElementInSortedArray.singleNonDuplicate(new int[]{1, 1, 2, 3, 3, 4, 4, 8, 8}));
        Assertions.assertEquals(10, singleElementInSortedArray.singleNonDuplicate(new int[]{3, 3, 7, 7, 10, 11, 11}));
        Assertions.assertEquals(12, singleElementInSortedArray.singleNonDuplicate(new int[]{3, 3, 7, 7, 10, 10, 11, 11, 12}));
        Assertions.assertEquals(0, singleElementInSortedArray.singleNonDuplicate(new int[]{0, 1, 1, 3, 3, 4, 4, 8, 8}));
        Assertions.assertEquals(0, singleElementInSortedArray.singleNonDuplicate(new int[]{0}));
        Assertions.assertEquals(0, singleElementInSortedArray.singleNonDuplicate(new int[]{0, 1, 1}));
        Assertions.assertEquals(2, singleElementInSortedArray.singleNonDuplicate(new int[]{0, 0, 2}));
    }


}