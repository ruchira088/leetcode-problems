package com.ruchij;

public class ValidateBinarySearchTree {
    public static class TreeNode {
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

//    public boolean isValidBST(TreeNode root) {
//        return isValidBST(root, null, null);
//    }
//
//    private boolean isValidBST(TreeNode treeNode, Integer min, Integer max) {
//        if (treeNode == null) {
//            return true;
//        } else if ((min == null || min < treeNode.val) && (max == null || max > treeNode.val)) {
//            return isValidBST(treeNode.left, min, treeNode.val) && isValidBST(treeNode.right, treeNode.val, max);
//        } else {
//            return false;
//        }
//    }

    private Integer previous;

    public boolean isValidBST(TreeNode root) {
        if (root == null) {
            return true;
        } else {
            if (isValidBST(root.left)) {
                if (previous == null || previous < root.val) {
                    previous = root.val;
                    return isValidBST(root.right);
                }
            }

            return false;
        }
    }
}
