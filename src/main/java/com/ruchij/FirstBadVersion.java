package com.ruchij;

public class FirstBadVersion {
    private final int first;

    public FirstBadVersion(int first) {
        this.first = first;
    }

    boolean isBadVersion(int version) {
        return version >= first;
    }

    public int firstBadVersion(int n) {
        return firstBadVersion(1, n);
    }

    public int firstBadVersion(int start, int end) {
        if (start == end) {
            return start;
        }

        int midPoint = (start + end) / 2;

        if (isBadVersion(midPoint)) {
            return firstBadVersion(start, midPoint);
        } else {
            return firstBadVersion(midPoint + 1, end);
        }
    }
}
