package com.ruchij;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class IntersectionSizeTwoTest {

    @Test
    void returnsExpectedResult() {
        IntersectionSizeTwo intersectionSizeTwo = new IntersectionSizeTwo();

        int[][] inputOne = new int[][]{{1, 3}, {3, 7}, {8, 9}};
        Assertions.assertEquals(5, intersectionSizeTwo.intersectionSizeTwo(inputOne));

        int[][] inputTwo = new int[][]{{1, 3}, {1, 4}, {2, 5}, {3, 5}};
        Assertions.assertEquals(3, intersectionSizeTwo.intersectionSizeTwo(inputTwo));

        int[][] inputThree = new int[][]{{1, 2}, {2, 3}, {2, 4}, {4, 5}};
        Assertions.assertEquals(5, intersectionSizeTwo.intersectionSizeTwo(inputThree));

        int[][] inputFour = new int[][]{{2, 10}, {3, 7}, {3, 15}, {4, 11}, {6, 12}, {6, 16}, {7, 8}, {7, 11}, {7, 15}, {11, 12}};
        Assertions.assertEquals(5, intersectionSizeTwo.intersectionSizeTwo(inputFour));

        int[][] inputFive = new int[][]{{1, 24}, {10, 16}, {14, 25}, {0, 18}, {16, 17}};
        Assertions.assertEquals(3, intersectionSizeTwo.intersectionSizeTwo(inputFive));

        int[][] inputSix = new int[][]{{0, 2}, {0, 3}, {0, 2}};
        Assertions.assertEquals(2, intersectionSizeTwo.intersectionSizeTwo(inputSix));

        int[][] inputSeven = new int[][]{{3, 13}, {2, 8}, {5, 10}};
        Assertions.assertEquals(2, intersectionSizeTwo.intersectionSizeTwo(inputSeven));
    }

}