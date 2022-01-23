package com.ruchij;

import org.junit.jupiter.api.Test;

public class ValidateBinarySearchTreeTest {
    private final ValidateBinarySearchTree validateBinarySearchTree = new ValidateBinarySearchTree();

    @Test
    void validate() {
        ValidateBinarySearchTree.TreeNode treeNode =
                new ValidateBinarySearchTree.TreeNode(
                        5,
                        new ValidateBinarySearchTree.TreeNode(4, null, null),
                        new ValidateBinarySearchTree.TreeNode(6,
                                new ValidateBinarySearchTree.TreeNode(3, null, null),
                                new ValidateBinarySearchTree.TreeNode(7, null, null)
                        )
                );

        ValidateBinarySearchTree.TreeNode treeNodeTwo =
                new ValidateBinarySearchTree.TreeNode(
                        2,
                        new ValidateBinarySearchTree.TreeNode(1, null, null),
                        new ValidateBinarySearchTree.TreeNode(3, null, null)
                );

        System.out.println(validateBinarySearchTree.isValidBST(treeNodeTwo));

    }
}
