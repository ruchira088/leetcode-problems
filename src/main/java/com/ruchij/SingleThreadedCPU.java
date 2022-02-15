package com.ruchij;

import java.util.*;

public class SingleThreadedCPU {
    static final class Task {
        private int start;
        private int duration;
        private boolean scheduled;
        private int index;

        Task(int start, int duration, boolean scheduled, int index) {
            this.start = start;
            this.duration = duration;
            this.scheduled = scheduled;
            this.index = index;
        }

        public int start() {
            return start;
        }

        public int duration() {
            return duration;
        }

        public boolean scheduled() {
            return scheduled;
        }

        public int index() {
            return index;
        }

        @Override
        public boolean equals(Object obj) {
            if (obj == this) return true;
            if (obj == null || obj.getClass() != this.getClass()) return false;
            var that = (Task) obj;
            return this.start == that.start &&
                    this.duration == that.duration &&
                    this.scheduled == that.scheduled &&
                    this.index == that.index;
        }

        @Override
        public int hashCode() {
            return Objects.hash(start, duration, scheduled, index);
        }

        @Override
        public String toString() {
            return "Task[" +
                    "startIndex=" + start + ", " +
                    "duration=" + duration + ", " +
                    "scheduled=" + scheduled + ", " +
                    "index=" + index + ']';
        }
    }

    public int[] getOrder(int[][] input) {
        List<Integer> results = new ArrayList<>();
        Task[] tasks = new Task[input.length];

        for (int i = 0; i < input.length; i++) {
            tasks[i] = new Task(input[i][0], input[i][1], false, i);
        }

        int time = 0;
        int index = 1;

        Arrays.sort(tasks, Comparator.comparingInt(Task::start).thenComparing(Task::duration));
        PriorityQueue<Task> queue = new PriorityQueue<>(Comparator.comparingInt(Task::duration).thenComparing(Task::index));
        queue.add(tasks[0]);

        while (!queue.isEmpty()) {
            Task task = queue.poll();
            results.add(task.index);

            time = Math.max(time, task.start) + task.duration;
            index = update(queue, time, index, tasks);
        }


        return results.stream().mapToInt(x -> x).toArray();
    }

    private int update(PriorityQueue<Task> queue, int time, int start, Task[] tasks) {
        for (int i = start; i < tasks.length; i++) {
            Task task = tasks[i];

            if (task.start <= time) {
                queue.add(task);
            } else {
                if (queue.isEmpty()) {
                    break;
                } else {
                    return i;
                }
            }
        }

        if (queue.isEmpty() && start < tasks.length) {
            queue.add(tasks[start]);
            return start + 1;
        }

        return tasks.length;
    }
}
