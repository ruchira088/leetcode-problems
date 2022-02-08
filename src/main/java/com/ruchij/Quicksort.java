package com.ruchij;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Quicksort {
    public List<Integer> sort(List<Integer> values) {
        if (values.size() <= 1) {
            return values;
        } else {
            Integer head = values.remove(0);
            ArrayList<Integer> result = new ArrayList<>();

            List<Integer> left = values.stream().filter(value -> value < head).collect(Collectors.toList());
            List<Integer> right = values.stream().filter(value -> value >= head).collect(Collectors.toList());

            result.addAll(sort(left));
            result.add(head);
            result.addAll(sort(right));

            return result;
        }
    }

    public int[] sort(int[] values) {
        return sort(values, 0, values.length - 1);
    }

    public int[] sort(int[] values, int start, int end) {
        if (start < end) {
            int tail = values[end];
            int left = 0;
            int right = 0;

            int[] higher = new int[end - start];

            for (int i = start; i < end; i++) {
                if (values[i] < tail) {
                    values[start + left] = values[i];
                    left++;
                } else {
                    higher[right] = values[i];
                    right++;
                }
            }

            int pivot = start + left;
            values[pivot] = tail;
            sort(values, start, pivot - 1);

            left++;

            for (int i = 0; i < right; i++) {
                values[start + left + i] = higher[i];
            }

            sort(values, pivot + 1, end);

        }

        return values;
    }


}
