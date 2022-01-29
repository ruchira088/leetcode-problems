package com.ruchij;

import java.util.ArrayList;
import java.util.List;

public class MergeSort {
    public List<Integer> sort(List<Integer> list) {
        int size = list.size();

        if (size <= 1) {
            return list;
        } else {
            int pivot = size / 2;
            List<Integer> left = sort(list.subList(0, pivot));
            List<Integer> right = sort(list.subList(pivot, size));

            return merge(left, right);
        }
    }

    private List<Integer> merge(List<Integer> listOne, List<Integer> listTwo) {
        int i = 0;
        int j = 0;

        List<Integer> result = new ArrayList<>();

        while (i < listOne.size() || j < listTwo.size()) {
            if (i == listOne.size()) {
                result.addAll(listTwo.subList(j, listTwo.size()));
                return result;
            } else if (j == listTwo.size()) {
                result.addAll(listOne.subList(i, listOne.size()));
                return result;
            } else {
                int one = listOne.get(i);
                int two = listTwo.get(j);

                if (one <= two) {
                    result.add(one);
                    i++;
                } else {
                    result.add(two);
                    j++;
                }
            }
        }

        return result;
    }

    int[] merge(int[] arrayOne, int[] arrayTwo) {
        int[] result = new int[arrayOne.length + arrayTwo.length];
        int i = 0;
        int j = 0;

        while (i < arrayOne.length  || j < arrayTwo.length) {
            if (i == arrayOne.length) {
                System.arraycopy(arrayTwo, j, result, j + i, arrayTwo.length - j);
                break;
            } else if (j == arrayTwo.length) {
                System.arraycopy(arrayOne, i, result, j + i, arrayOne.length - i);
                break;
            } else {
                int one = arrayOne[i];
                int two = arrayTwo[j];

                if (one <= two) {
                    result[i + j] = one;
                    i++;
                } else {
                    result[i + j] = two;
                    j++;
                }
            }
        }

        return result;
    }
}
