package com.ruchij;

public class ValidateBinarySearchTree {
    record TreeNode(int val, TreeNode left, TreeNode right) {}
    record Result(boolean isValid, Integer previous) { }

//    public boolean isValidBST(TreeNode root) {
//        return isValid(root, null).isValid;
//    }
//
//    public Result isValid(TreeNode root, Integer previous) {
//        if (root == null) {
//            return new Result(true, previous);
//        } else {
//            Result leftResult = isValid(root.left, previous);
//
//            if (leftResult.isValid && (leftResult.previous == null || leftResult.previous < root.val)) {
//                return isValid(root.right, root.val);
//            } else {
//                return new Result(false, previous);
//            }
//        }
//    }

    public boolean isValidBST(TreeNode root) {
        return isValidBST(root, null, null);
    }

    private boolean isValidBST(TreeNode treeNode, Integer min, Integer max) {
        if (treeNode == null) {
            return true;
        } else {
            if ((min == null || min < treeNode.val) && (max == null || max > treeNode.val)) {
                return isValidBST(treeNode.left, min, treeNode.val) && isValidBST(treeNode.right, treeNode.val, max);
            } else {
                return false;
            }
        }
    }


}
