package com.ruchij;

import java.util.Comparator;
import java.util.List;

public class ListSort {
    public static Comparator<List<Integer>> listComparator =
            new Comparator<>() {
                @Override
                public int compare(List<Integer> o1, List<Integer> o2) {
                    if (o1.isEmpty() && o2.isEmpty()) {
                        return 0;
                    } else if (o1.isEmpty()) {
                        return -1;
                    } else if (o2.isEmpty()) {
                        return 1;
                    } else {
                        Integer one = o1.get(0);
                        Integer two = o2.get(0);

                        int result = one - two;

                        return result == 0 ? compare(o1.subList(1, o1.size()), o2.subList(1, o2.size())) : result;
                    }
                }
            };
}
