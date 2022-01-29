package com.ruchij;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;

public class MergeIntervals {
    static final class Interval {
        private final int start;
        private final int end;

        Interval(int start, int end) {
            this.start = start;
            this.end = end;
        }

        public int start() {
            return start;
        }

        public int end() {
            return end;
        }

        @Override
        public boolean equals(Object obj) {
            if (obj == this) return true;
            if (obj == null || obj.getClass() != this.getClass()) return false;
            var that = (Interval) obj;
            return this.start == that.start &&
                    this.end == that.end;
        }

        @Override
        public int hashCode() {
            return Objects.hash(start, end);
        }

        @Override
        public String toString() {
            return "Interval[" +
                    "start=" + start + ", " +
                    "end=" + end + ']';
        }
    }

    public int[][] merge(int[][] intervals) {
        List<Interval> intervalList = new ArrayList<>();

        for (int[] value: intervals) {
            intervalList.add(new Interval(value[0], value[1]));
        }

        intervalList.sort(Comparator.comparingInt(Interval::start));

        ArrayList<Interval> result = new ArrayList<>();
        Interval current = null;

        for (Interval interval: intervalList) {
            if (current == null) {
                current = interval;
            } else {
                if (interval.start <= current.end) {
                    current = new Interval(current.start, Math.max(interval.end, current.end));
                } else {
                    result.add(current);
                    current = interval;
                }
            }
        }

        if (current != null) {
            result.add(current);
        }

        return result.stream()
                .map(interval -> {
                    int[] value = new int[2];
                    value[0] = interval.start;
                    value[1] = interval.end;

                    return value;
                })
                .toArray(int[][]::new);
    }
}
