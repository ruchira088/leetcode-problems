package com.ruchij;

import org.junit.jupiter.api.Test;

import java.util.stream.IntStream;

class FindingUsersActiveMinutesTest {

    @Test
    void returnsExpectedResult() {
        FindingUsersActiveMinutes findingUsersActiveMinutes = new FindingUsersActiveMinutes();

        System.out.println(IntStream.of(findingUsersActiveMinutes.findingUsersActiveMinutes(new int[][]{{0, 5}, {1, 2}, {0, 2}, {0, 5}, {1, 3}}, 5)).boxed().toList());
        System.out.println(IntStream.of(findingUsersActiveMinutes.findingUsersActiveMinutes(new int[][]{{1, 1}, {2, 2}, {2, 3}}, 4)).boxed().toList());
    }

}