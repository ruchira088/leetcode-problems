package com.ruchij;

import java.util.ArrayDeque;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

class LRUCache {
    private final Map<Integer, Integer> cache;
    private final AtomicInteger size = new AtomicInteger(0);
    private final ArrayDeque<Integer> order;

    private final int capacity;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.cache = new ConcurrentHashMap<>(capacity);
        this.order = new ArrayDeque<>();
    }

    public int get(int key) {
        Integer result = cache.get(key);

        if (result == null) {
            return -1;
        } else {
            order.remove(key);
            order.push(key);

            return result;
        }
    }

    public void put(int key, int value) {
        boolean contains = cache.containsKey(key);

        if (!contains) {
            if (size.get() < capacity) {
                size.incrementAndGet();
            } else {
                Integer last = order.pollLast();
                cache.remove(last);
            }
        } else {
            order.remove(key);
        }

        order.push(key);
        cache.put(key, value);
    }
}