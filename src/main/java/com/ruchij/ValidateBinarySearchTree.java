package com.ruchij;

public class ValidateBinarySearchTree {
    record TreeNode(int val, TreeNode left, TreeNode right) {}

//    public boolean isValidBST(TreeNode root) {
//        return isValidBST(root, null, null);
//    }
//
//    private boolean isValidBST(TreeNode root, Integer min, Integer max) {
//        if (root == null) {
//            return true;
//        } else {
//            int value = root.val;
//
//            if ((min == null || min < value) && (max == null || max > value)) {
//                return isValidBST(root.left, min, value) && isValidBST(root.right, value, max);
//            } else {
//                return false;
//            }
//        }
//    }

    private Integer previous;

    public boolean isValidBST(TreeNode root) {
        if (root == null) {
            return true;
        } else {
            if (isValidBST(root.left)) {
                int value = root.val;

                if (previous == null || previous < value) {
                    previous = value;

                    return isValidBST(root.right);
                }
            }

            return false;
        }
    }


}
