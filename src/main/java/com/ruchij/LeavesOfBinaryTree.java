package com.ruchij;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class LeavesOfBinaryTree {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }

        @Override
        public String toString() {
            return "\n(\n" + val + ", \n" + left + ", \n" + right + "\n)\n";
        }
    }

    public List<List<Integer>> findLeaves(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();

        while (root != null && !isLeaf(root)) {
            List<Integer> list = removeLeaves(root);
            result.add(list);
        }

        if (root != null) {
            result.add(List.of(root.val));
        }

        return result;
    }

    List<Integer> removeLeaves(TreeNode node) {
        List<Integer> leaves = new LinkedList<>();

        if (node != null) {
            TreeNode left = node.left;

            if (left != null && isLeaf(left)) {
                node.left = null;
                leaves.add(left.val);
            } else {
                leaves.addAll(removeLeaves(left));
            }

            TreeNode right = node.right;

            if (right != null && isLeaf(right)) {
                node.right = null;
                leaves.add(right.val);
            } else {
                leaves.addAll(removeLeaves(right));
            }
        }

        return leaves;
    }

    private boolean isLeaf(TreeNode treeNode) {
        return treeNode.left == null && treeNode.right == null;
    }
}
