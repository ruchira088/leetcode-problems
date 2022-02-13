package com.ruchij;

import java.util.HashMap;
import java.util.Map;

public class MaximumLevelSumBST {
    record TreeNode(int val, TreeNode left, TreeNode right) {}

    public int maxLevelSum(TreeNode root) {
        Map<Integer, Integer> sums = new HashMap<>();
        maxLevelSum(root, sums, 1);
        Integer max = null;
        Integer level = null;


        for (Map.Entry<Integer, Integer> entry : sums.entrySet()) {
            if (max == null || entry.getValue() > max) {
                level = entry.getKey();
                max = entry.getValue();
            } else if (max.equals(entry.getValue())) {
                if (entry.getKey() < level) {
                    level = entry.getKey();
                }
            }
        }

        return level;
    }

    private void maxLevelSum(TreeNode root, Map<Integer, Integer> sums, int level) {
        if (root != null) {
            maxLevelSum(root.left, sums, level + 1);
            sums.put(level, sums.getOrDefault(level, 0) + root.val);
            maxLevelSum(root.right, sums, level + 1);
        }
    }
}
