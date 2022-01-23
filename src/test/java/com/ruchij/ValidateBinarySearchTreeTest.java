package com.ruchij;

import org.junit.jupiter.api.Test;

public class ValidateBinarySearchTreeTest {
    private final ValidateBinarySearchTree validateBinarySearchTree = new ValidateBinarySearchTree();

    @Test
    void validate() {
        ValidateBinarySearchTree.TreeNode treeNode =
                new ValidateBinarySearchTree.TreeNode(
                        5,
                        new ValidateBinarySearchTree.TreeNode(4),
                        new ValidateBinarySearchTree.TreeNode(6,
                                new ValidateBinarySearchTree.TreeNode(3),
                                new ValidateBinarySearchTree.TreeNode(7)
                        )
                );

        ValidateBinarySearchTree.TreeNode treeNodeTwo =
                new ValidateBinarySearchTree.TreeNode(
                        2,
                        new ValidateBinarySearchTree.TreeNode(1),
                        new ValidateBinarySearchTree.TreeNode(3)
                );

        System.out.println(validateBinarySearchTree.isValidBST(treeNodeTwo));

    }
}
