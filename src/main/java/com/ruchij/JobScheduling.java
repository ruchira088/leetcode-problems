package com.ruchij;

import java.util.*;
import java.util.stream.Collectors;

public class JobScheduling {
    static final class Job {
        private final int start;
        private final int end;
        private final int profit;

        Job(int start, int end, int profit) {
            this.start = start;
            this.end = end;
            this.profit = profit;
        }

        public int start() {
            return start;
        }

        public int end() {
            return end;
        }

        public int profit() {
            return profit;
        }

        @Override
        public boolean equals(Object obj) {
            if (obj == this) return true;
            if (obj == null || obj.getClass() != this.getClass()) return false;
            var that = (Job) obj;
            return this.start == that.start &&
                    this.end == that.end &&
                    this.profit == that.profit;
        }

        @Override
        public int hashCode() {
            return Objects.hash(start, end, profit);
        }

        @Override
        public String toString() {
            return "Job[" +
                    "startIndex=" + start + ", " +
                    "end=" + end + ", " +
                    "profit=" + profit + ']';
        }
    }

    static final class State {
        private final int end;
        private final int profit;

        State(int end, int profit) {
            this.end = end;
            this.profit = profit;
        }

        public int end() {
            return end;
        }

        public int profit() {
            return profit;
        }

        @Override
        public boolean equals(Object obj) {
            if (obj == this) return true;
            if (obj == null || obj.getClass() != this.getClass()) return false;
            var that = (State) obj;
            return this.end == that.end &&
                    this.profit == that.profit;
        }

        @Override
        public int hashCode() {
            return Objects.hash(end, profit);
        }

        @Override
        public String toString() {
            return "State[" +
                    "end=" + end + ", " +
                    "profit=" + profit + ']';
        }
    }

    public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
        List<Job> jobs = new ArrayList<>();

        for (int i = 0; i < startTime.length; i++) {
            jobs.add(new Job(startTime[i], endTime[i], profit[i]));
        }

        int max = Arrays.stream(endTime).max().orElseThrow();

        Map<Integer, List<Job>> jobsByStart = jobs.stream().collect(Collectors.groupingBy(Job::start));

        ArrayDeque<State> schedules = new ArrayDeque<>();
        schedules.push(new State(0, 0));
        Integer[] maxProfit = new Integer[max + 1];


        while (!schedules.isEmpty()) {
           State schedule = schedules.pop();

           if (maxProfit[schedule.end] == null || maxProfit[schedule.end] == schedule.profit) {
               maxProfit[schedule.end] = schedule.profit;

               if (schedule.end < max) {
                   schedules.add(new State(schedule.end + 1, schedule.profit));
               }

               List<Job> startingJobs = jobsByStart.getOrDefault(schedule.end, List.of());

               for (Job job: startingJobs) {
                   State state = new State(job.end, job.profit + schedule.profit);

                   if (maxProfit[state.end] == null || maxProfit[state.end] < state.profit) {
                       schedules.add(state);
                   }

               }
           }
        }

        return maxProfit[max];
    }
}
