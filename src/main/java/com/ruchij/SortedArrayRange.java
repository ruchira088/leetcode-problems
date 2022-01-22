package com.ruchij;

public class SortedArrayRange {
    public record Range(int first, int last) {}

    public Range solve(int[] data, int number) {
        int first = findFirst(data, number);
        int last = findLast(data, number);

        return new Range(first, last);
    }

    public int findIndex(int[] data, int target, int start, int end) {
        int midPoint = (start + end) / 2;
        int value = data[midPoint];

        if (value == target) {
            return midPoint;
        } else if (start == end) {
            throw new RuntimeException("Unable to find: " + target);
        } else if (value > target) {
            return findIndex(data, target, start, midPoint - 1);
        } else {
            return findIndex(data, target, midPoint + 1, end);
        }
    }

    public int findFirst(int[] data, int target) {
        return findFirst(data, target, 0, data.length - 1);
    }

    public int findLast(int[] data, int target) {
        return findLast(data, target, 0, data.length - 1);
    }

    private int findFirst(int[] data, int target, int start, int end) {
        int midPoint = (int) Math.floor((start + end) / 2.0);
        int value = data[midPoint];

        if (value == target && end == start) {
            return midPoint;
        } else if (end == start) {
            throw new RuntimeException("Unable to find: " + target);
        }  else if (value >= target) {
            return findFirst(data, target, start, midPoint);
        } else {
            return findFirst(data, target, midPoint + 1, end);
        }
    }

    private int findLast(int[] data, int target, int start, int end) {
        int midPoint = (int) Math.ceil((start + end) / 2.0);
        int value = data[midPoint];

        if (value == target && end == start) {
            return midPoint;
        } else if (end == start) {
            throw new RuntimeException("Unable to find: " + target);
        }  else if (value > target) {
            return findLast(data, target, start, midPoint - 1);
        } else {
            return findLast(data, target, midPoint, end);
        }
    }

}
