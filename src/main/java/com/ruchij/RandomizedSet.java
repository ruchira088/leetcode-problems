package com.ruchij;

import java.util.*;

public class RandomizedSet {
    HashMap<Integer, Integer> indexes = new HashMap<>();
    ArrayList<Integer> numbers = new ArrayList<>();

    public RandomizedSet() {
    }

    public boolean insert(int val) {
        if (indexes.containsKey(val)) {
            return false;
        } else {
            int size = numbers.size();
            indexes.put(val, size);
            numbers.add(val);

            return true;
        }
    }

    public boolean remove(int val) {
        if (indexes.containsKey(val)) {
            int index = indexes.get(val);
            int lastIndex = numbers.size() - 1;
            int last = numbers.get(lastIndex);

            numbers.remove(lastIndex);
            indexes.remove(val);

            if (lastIndex != index) {
                numbers.remove(index);
                numbers.add(index, last);

                indexes.put(last, index);
            }

            return true;
        } else {
            return false;
        }
    }

    public int getRandom() {
        int random = (int) Math.floor(Math.random() * numbers.size());

        return numbers.get(random);
    }
}
