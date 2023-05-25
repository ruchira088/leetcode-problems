package com.ruchij;

import java.util.Arrays;

public class MinimumTimeToCompleteTrips {
    public long minimumTime(int[] time, int totalTrips) {
        int smallestTrip = Arrays.stream(time).min().getAsInt();

        long left = smallestTrip;
        long right = smallestTrip * (long) totalTrips;

        if (totalTrips == 0) {
            return 0;
        } else {
            while (left != right) {
                long midPoint = (left + right) / 2;

                long trips = totalTrips(time, midPoint, totalTrips);

                if (trips >= totalTrips) {
                    right = midPoint;
                } else {
                    if (left == midPoint) {
                        break;
                    }

                    left = midPoint;
                }
            }
        }

        return right;
    }

    private long totalTrips(int[] times, long timestamp, int max) {
        long trips = 0;

        for (int trip : times) {
            trips += timestamp / trip;

            if (trips > max) {
                break;
            }
        }

        return trips;
    }
}
