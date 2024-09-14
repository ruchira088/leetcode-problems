package com.ruchij.google;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class MeetingRooms2 {
    public int minMeetingRooms(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparing(interval -> interval[0]));
        PriorityQueue<Integer> integers = new PriorityQueue<>();

        for (int[] interval : intervals) {
            int startTime = interval[0];
            int endTime = interval[1];

            if (integers.isEmpty()) {
                integers.add(endTime);
            } else {
                int finishTime = integers.peek();
                if (finishTime <= startTime) {
                    integers.poll();
                }

                integers.add(endTime);
            }

        }

        return integers.size();
    }
}
