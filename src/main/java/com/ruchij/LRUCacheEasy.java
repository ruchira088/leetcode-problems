package com.ruchij;

import java.util.LinkedHashMap;
import java.util.Map;

public class LRUCacheEasy extends LinkedHashMap<Integer, Integer> {
    private final int capacity;

    public LRUCacheEasy(int capacity) {
        super(capacity, 0.75f);
        this.capacity = capacity;
    }

    public int get(int key) {
        Integer value = remove(key);

        if (value == null) {
            return -1;
        } else {
            put(key, (int) value);
            return value;
        }
    }

    public void put(int key, int value) {
        super.put(key, value);
    }

    @Override
    protected boolean removeEldestEntry(Map.Entry<Integer, Integer> eldest) {
        return size() > capacity;
    }
}
