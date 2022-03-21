package com.ruchij;

import java.util.Comparator;
import java.util.SortedSet;
import java.util.TreeSet;
import java.util.concurrent.atomic.AtomicInteger;

public class DesignHitCounter {
    static class HitCounter {
        record Tuple(int timestamp, int count) {}

        private static final int TIME_WINDOW = 300;
        private TreeSet<Tuple> timestamps = new TreeSet<>(Comparator.comparingInt(Tuple::timestamp));
        private final AtomicInteger count = new AtomicInteger();

        public HitCounter() {
            hit(0);
        }

        public void hit(int timestamp) {
            Tuple floor = timestamps.lower(new Tuple(timestamp - TIME_WINDOW, 0));

            timestamps = (TreeSet<Tuple>) timestamps.tailSet(floor == null ? new Tuple(0, 0) : floor);

            if (!timestamps.isEmpty()) {
                Tuple last = timestamps.last();

                if (last != null && last.timestamp == timestamp) {
                    timestamps.remove(last);
                }
            }

            timestamps.add(new Tuple(timestamp, count.getAndIncrement()));
        }

        public int getHits(int timestamp) {
            SortedSet<Tuple> range = timestamps.subSet(new Tuple(Math.max(0, timestamp - TIME_WINDOW) + 1, 0), new Tuple(timestamp + 1,0));
            if (range.size() == 0) {
                return 0;
            }

            int last = range.last().count;
            int first = timestamps.lower(range.first()).count;

            return last - first;
        }
    }
}
