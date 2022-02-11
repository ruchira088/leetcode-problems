package com.ruchij;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

public class Duplicates {
    public boolean containsDuplicate(int[] nums) {
        Set<Integer> integers = Arrays.stream(nums).boxed().collect(Collectors.toSet());
        return nums.length == integers.size();
    }
}
