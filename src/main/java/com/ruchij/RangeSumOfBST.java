package com.ruchij;

public class RangeSumOfBST {
    record TreeNode(int val, TreeNode left, TreeNode right) {}

    public int rangeSumBST(TreeNode root, int low, int high) {
        if (root == null) {
            return 0;
        } else {
            int sum = (root.val >= low && root.val <= high) ? root.val : 0;
            int leftSum = rangeSumBST(root.left, low, high);
            int rightSum = rangeSumBST(root.right, low, high);

            return sum + leftSum + rightSum;
        }
    }
}
