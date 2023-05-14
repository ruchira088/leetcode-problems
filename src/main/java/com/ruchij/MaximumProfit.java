package com.ruchij;

import java.util.*;

public class MaximumProfit {
    record Job(int start, int end, int profit) {}

    public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
        List<Job> jobs = parse(startTime, endTime, profit);
        TreeMap<Integer, Integer> treeMap = new TreeMap<>();
        treeMap.put(0, 0);

        for (Job job : jobs) {
            int value = treeMap.floorEntry(job.start).getValue() + job.profit;
            int lastValue = treeMap.lastEntry().getValue();

            if (value > lastValue) {
                treeMap.put(job.end, value);
            }
        }

        return treeMap.lastEntry().getValue();
    }

    private List<Job> parse(int[] startTime, int[] endTime, int[] profit) {
        ArrayList<Job> jobs = new ArrayList<>();

        for (int i = 0; i < startTime.length; i++) {
            Job job = new Job(startTime[i], endTime[i], profit[i]);
            jobs.add(job);
        }

        Comparator<Job> comparatorEndTime = Comparator.comparing(Job::end);

        jobs.sort(comparatorEndTime);

        return jobs;
    }
}
