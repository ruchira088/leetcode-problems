package com.ruchij;

import org.junit.jupiter.api.Test;

import java.util.List;

public class LeavesOfBinaryTreeTest {
    private final LeavesOfBinaryTree leavesOfBinaryTree = new LeavesOfBinaryTree();

    private LeavesOfBinaryTree.TreeNode createTreeNode() {
        return new LeavesOfBinaryTree.TreeNode(
                1,
                new LeavesOfBinaryTree.TreeNode(2, new LeavesOfBinaryTree.TreeNode(4), new LeavesOfBinaryTree.TreeNode(5)),
                new LeavesOfBinaryTree.TreeNode(3)
        );
    }

    @Test
    void findLeaves() {
        List<List<Integer>> leaves = leavesOfBinaryTree.findLeaves(createTreeNode());
        System.out.println(leaves);

    }
}
