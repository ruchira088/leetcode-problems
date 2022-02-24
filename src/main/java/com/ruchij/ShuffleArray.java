package com.ruchij;

import java.util.ArrayList;

public class ShuffleArray {
    class Solution {
        private final int[] nums;

        public Solution(int[] nums) {
            this.nums = nums;
        }

        public int[] reset() {
            return this.nums;
        }

        public int[] shuffle() {
            int[] shuffled = new int[this.nums.length];
            ArrayList<Integer> list = indexes(this.nums.length);

            int count = 0;

            while (!list.isEmpty()) {
                int index = (int) Math.floor(list.size() * Math.random());
                shuffled[count] = this.nums[list.get(index)];
                list.remove(index);
                count++;
            }

            return shuffled;
        }

        public ArrayList<Integer> indexes(int length) {
            ArrayList<Integer> arrayList = new ArrayList<>();

            for (int i = 0; i < length; i++) {
                arrayList.add(i);
            }

            return arrayList;
        }
    }
}
