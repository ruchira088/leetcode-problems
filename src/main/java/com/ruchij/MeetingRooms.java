package com.ruchij;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class MeetingRooms {
    record Meeting(int start, int end) {
    }

    public int minMeetingRooms(int[][] intervals) {
        Meeting[] meetings = new Meeting[intervals.length];

        for (int i = 0; i < intervals.length; i++) {
            meetings[i] = new Meeting(intervals[i][0], intervals[i][1]);
        }

        Arrays.sort(meetings, Comparator.comparingInt(Meeting::start));

        PriorityQueue<Integer> queue = new PriorityQueue<>();

        for (Meeting meeting : meetings) {
            if (!queue.isEmpty()) {
                int finishTime = queue.peek();

                if (finishTime <= meeting.start) {
                    queue.remove();
                }
            }

            queue.add(meeting.end);
        }

        return queue.size();
    }
}
