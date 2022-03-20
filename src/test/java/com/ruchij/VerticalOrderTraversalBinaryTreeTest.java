package com.ruchij;

import org.junit.jupiter.api.Test;

import static com.ruchij.VerticalOrderTraversalBinaryTree.TreeNode;

class VerticalOrderTraversalBinaryTreeTest {
    private final VerticalOrderTraversalBinaryTree verticalOrderTraversalBinaryTree =
            new VerticalOrderTraversalBinaryTree();

    @Test
    void testOne() {
        TreeNode treeNode =
                new TreeNode(3, new TreeNode(9, null, null), new TreeNode(20, new TreeNode(15, null, null), new TreeNode(7, null, null)));

        System.out.println(verticalOrderTraversalBinaryTree.verticalTraversal(treeNode));
    }

}