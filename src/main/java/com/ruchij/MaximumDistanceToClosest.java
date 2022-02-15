package com.ruchij;

public class MaximumDistanceToClosest {
    public int maxDistToClosest(int[] seats) {
        int maxDistance = 0;

        int distance = 0;
        int index = -1;

        for (int i = 0; i < seats.length; i++) {
            if (seats[i] == 0) {
                distance++;
            } else {
                distance = index == -1 ? distance : (distance + 1) / 2;

                if (maxDistance < distance) {
                    maxDistance = distance;
                }

                index = i;
                distance = 0;
            }
        }

        return Math.max(maxDistance, distance);

    }
}
