package com.ruchij;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ThreeSum {
    public List<List<Integer>> threeSum(int[] input) {
        Integer[] nums = minimize(input);
        Set<List<Integer>> result = new HashSet<>();
        Map<Integer, Set<Integer>> set = group(nums);

        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums.length; j++) {

                if (j != i) {
                    int valueI = nums[i];
                    int valueJ = nums[j];

                    int expectedK = -(valueI + valueJ);

                    Set<Integer> indexes = set.get(expectedK);

                    if (indexes != null) {
                        int a = j;
                        int b = i;
                        Optional<Integer> optionalInteger =
                                indexes.stream().filter(index -> index != a && index != b).findFirst();

                        optionalInteger.ifPresent(k -> {
                            List<Integer> list = Stream.of(nums[a], nums[b], nums[k]).sorted().collect(Collectors.toList());
                            result.add(list);
                        });
                    }
                }
            }
        }

        return result.stream().sorted(new Comparator<List<Integer>>() {
            @Override
            public int compare(List<Integer> listOne, List<Integer> listTwo) {
                Integer[] one = listOne.toArray(listOne.toArray(new Integer[0]));
                Integer[] two = listTwo.toArray(listOne.toArray(new Integer[0]));

                boolean oneHasNext = true;
                boolean twoHasNext = true;
                int index = 0;

                while (oneHasNext && twoHasNext && index < one.length && index < two.length) {
                    if (one[index] > two[index]) {
                        twoHasNext = false;
                    } else if (one[index] < two[index]) {
                        oneHasNext = false;
                    } else {
                        index++;
                    }
                }

                if (oneHasNext) {
                    return 1;
                } else {
                    return -1;
                }

            }
        }).collect(Collectors.toList());
    }

    private Integer[] minimize(int[] nums) {
        LinkedList<Integer> list = new LinkedList<>();

        Map<Integer, List<Integer>> integerListMap =
                Arrays.stream(nums).boxed().collect(Collectors.groupingBy(num -> num));

        for (Integer integer: integerListMap.keySet()) {
            List<Integer> integers = integerListMap.get(integer);

            if (integers.size() > 3) {
                list.addAll(List.of(integer, integer, integer));
            } else {
                list.addAll(integers);
            }
        }

        return list.toArray(new Integer[0]);
    }

    private Map<Integer, Set<Integer>> group(Integer[] nums) {
        Map<Integer, Set<Integer>> result = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int value = nums[i];
            Set<Integer> current = result.getOrDefault(value, new HashSet<>());
            current.add(i);

            result.put(value, current);
        }

        return result;
    }
}
