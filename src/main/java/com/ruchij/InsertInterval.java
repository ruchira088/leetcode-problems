package com.ruchij;

import java.util.*;

public class InsertInterval {
    record Interval(int start, int end) {}

    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<Interval> list = new ArrayList<>();
        Interval toAdd = new Interval(newInterval[0], newInterval[1]);

        for (int[] interval: intervals) {
            list.add(new Interval(interval[0], interval[1]));
        }

        int index = Collections.binarySearch(list, toAdd, Comparator.comparingInt(Interval::start).thenComparing(Interval::end));
        int indexToAdd = index >= 0 ? index : -(index + 1);

        list.add(indexToAdd, toAdd);

        PriorityQueue<Interval> queue = new PriorityQueue<>(Comparator.comparingInt(Interval::end).reversed());

        for (Interval interval: list) {
            if (queue.isEmpty()) {
                queue.add(interval);
            } else {
                Interval previous = queue.peek();

                if (previous.end >= interval.start) {
                    queue.poll();
                    queue.add(new Interval(Math.min(previous.start, interval.start), Math.max(previous.end, interval.end)));
                } else {
                    queue.add(interval);
                }
            }
        }

        int queueSize = queue.size();
        int[][] results = new int[queueSize][2];
        int i = 0;

        while (!queue.isEmpty()) {
            Interval interval = queue.poll();
            results[queueSize - 1 - i] = new int[] { interval.start, interval.end };
            i++;
        }

        return results;
    }

//    public int[][] insert(int[][] intervals, int[] newInterval) {
//        if (intervals.length == 0) {
//            return new int[][] { newInterval };
//        }
//
//        ArrayList<int[]> results = new ArrayList<>();
//        boolean added = false;
//        boolean pending = false;
//
//        for (int[] interval : intervals) {
//            if (added || noOverlap(interval, newInterval)) {
//                if (pending) {
//                    results.add(newInterval);
//                    pending = false;
//                    added = true;
//                }
//                results.add(interval);
//            } else {
//                pending = true;
//                newInterval[0] = Math.min(interval[0], newInterval[0]);
//                newInterval[1] = Math.max(interval[1], newInterval[1]);
//            }
//        }
//
//        if (!added) {
//            results.add(newInterval);
//        }
//
//        return results.toArray(int[][]::new);
//    }
//
//    boolean noOverlap(int[] one, int[] two) {
//        return one[1] < two[0] || two[1] < one[0];
//    }
}
