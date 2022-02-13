package com.ruchij;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class MeetingRoomsTest {
    private final MeetingRooms meetingRooms = new MeetingRooms();

    @Test
    void testOne() {
        int[][] meetings = {{0, 30}, {5, 10}, {15, 20}};
        Assertions.assertEquals(2, meetingRooms.minMeetingRooms(meetings));
    }

    @Test
    void testTwo() {
        int[][] meetings = {{7, 10}, {2, 4}};
        Assertions.assertEquals(1, meetingRooms.minMeetingRooms(meetings));
    }

}