package com.ruchij;

import java.util.concurrent.ConcurrentHashMap;

class SnapshotArray {
    private volatile int snapshotId = 0;

    private final ConcurrentHashMap<Integer, Integer[]> snapshots = new ConcurrentHashMap<>();

    private Integer[] array;

    public SnapshotArray(int length) {
        this.array = new Integer[length];
    }

    public void set(int index, int val) {
        this.array[index] = val;
    }

    public int snap() {
        int id = snapshotId;
        snapshots.put(id, clone(this.array));
        snapshotId++;

        return id;
    }

    public int get(int index, int snap_id) {
        if (snap_id == snapshotId) {
            return this.array[index];
        } else {
            Integer[] integers = this.snapshots.get(snap_id);

            if (integers[index] == null) {
                return 0;
            } else {
                return integers[index];
            }
        }
    }

    private Integer[] clone(Integer[] input) {
        Integer[] result = new Integer[input.length];

        System.arraycopy(input, 0, result, 0, input.length);

        return result;
    }
}
