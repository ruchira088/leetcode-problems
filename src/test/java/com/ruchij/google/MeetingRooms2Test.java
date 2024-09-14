package com.ruchij.google;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MeetingRooms2Test {
    private static final MeetingRooms2 solution = new MeetingRooms2();

    @Test
    void verifyResults() {
        assertEquals(2, solution.minMeetingRooms(new int[][]{new int[]{0, 30}, new int[]{5, 10}, new int[]{15, 20}}));
        assertEquals(1, solution.minMeetingRooms(new int[][]{new int[]{7, 10}, new int[]{2, 4}}));
    }

}