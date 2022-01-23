package com.ruchij;

public class InvertBinarySearchTree {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public TreeNode invertTree(TreeNode root) {
        if (root != null) {
            TreeNode treeNode = new TreeNode();
            treeNode.val = root.val;

            treeNode.left = invertTree(root.right);
            treeNode.right = invertTree(root.left);

            return treeNode;
        } else {
            return null;
        }
    }
}
