package com.ruchij;

import java.util.*;

public class MinimumTimeDifference {
    record Time(int hours, int minutes) {
        int full() {
            return hours * 60 + minutes;
        }
    }

    public int findMinDifference(List<String> timePoints) {
        List<Time> times = new ArrayList<>();

        for (String timePoint: timePoints) {
            String[] time = timePoint.split(":");
            int hours = Integer.parseInt(time[0]);
            int minutes = Integer.parseInt(time[1]);

            times.add(new Time(hours, minutes));

            if (hours < 12) {
                times.add(new Time(hours + 24, minutes));
            }
        }

        times.sort(Comparator.comparingInt(Time::full));

        Integer min = null;
        Time last = null;

        for (Time time: times) {
            if (last != null) {
                int diff = time.full() - last.full();

                if (min == null || diff < min) {
                    min = diff;
                }

            }
            last = time;
        }

        return min;
    }
}
