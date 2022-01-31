package com.ruchij;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class JobSchedulingTest {
    private final JobScheduling jobScheduling = new JobScheduling();

    @Test
    void testOne() {
        int[] startTimes = {1, 2, 3, 3};
        int[] endTimes = {3, 4, 5, 6};
        int[] profits = {50, 10, 40, 70};

        int max = jobScheduling.jobScheduling(startTimes, endTimes, profits);

        Assertions.assertEquals(120, max);
    }

}