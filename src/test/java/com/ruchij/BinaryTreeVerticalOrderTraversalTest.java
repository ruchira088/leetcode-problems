package com.ruchij;

import com.ruchij.BinaryTreeVerticalOrderTraversal.TreeNode;
import org.junit.jupiter.api.Test;

class BinaryTreeVerticalOrderTraversalTest {
    private final BinaryTreeVerticalOrderTraversal binaryTreeVerticalOrderTraversal = new BinaryTreeVerticalOrderTraversal();

    @Test
    void testOne() {
        TreeNode treeNode =
                new TreeNode(3, new TreeNode(9, null, null), new TreeNode(20, new TreeNode(15, null, null), new TreeNode(7, null, null)));

        System.out.println(binaryTreeVerticalOrderTraversal.verticalOrder(treeNode));
    }

}