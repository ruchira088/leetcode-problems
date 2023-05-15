package com.ruchij;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MinimumRoundsToCompleteAllTasksTest {

    @Test
    void returnsExpectedResult() {
        MinimumRoundsToCompleteAllTasks minimumRoundsToCompleteAllTasks = new MinimumRoundsToCompleteAllTasks();
        assertEquals(4, minimumRoundsToCompleteAllTasks.minimumRounds(new int[]{2, 2, 3, 3, 2, 4, 4, 4, 4, 4}));
        assertEquals(-1, minimumRoundsToCompleteAllTasks.minimumRounds(new int[]{2, 3, 3}));
    }

}