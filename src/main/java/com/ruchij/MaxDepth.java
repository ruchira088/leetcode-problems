package com.ruchij;

public class MaxDepth {
    record TreeNode(int val, TreeNode left, TreeNode right) {}

    private Integer depth;

    public int maxDepth(TreeNode root) {
        return findMaxDepth(root, 0);
    }

    public int findMaxDepth(TreeNode root, int current) {
        if (root == null) {
            return current;
        } else {
            int leftTree = findMaxDepth(root.left, current + 1);
            int rightTree = findMaxDepth(root.right, current + 1);

            return Math.max(leftTree, rightTree);
        }
    }
}
