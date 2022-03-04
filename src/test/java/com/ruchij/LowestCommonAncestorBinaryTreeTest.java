package com.ruchij;

import com.ruchij.LowestCommonAncestorBinaryTree.TreeNode;
import org.junit.jupiter.api.Test;

class LowestCommonAncestorBinaryTreeTest {
    private final LowestCommonAncestorBinaryTree lowestCommonAncestorBinaryTree = new LowestCommonAncestorBinaryTree();

    TreeNode treeNode =
            new TreeNode(3,
                    new TreeNode(5,
                            new TreeNode(6, null, null),
                            new TreeNode(2,
                                    new TreeNode(7, null, null),
                                    new TreeNode(4, null, null)
                            )
                    ),
                    new TreeNode(1,
                            new TreeNode(0, null, null),
                            new TreeNode(8, null, null)
                    )

            );

    @Test
    void testOne() {
        TreeNode result = lowestCommonAncestorBinaryTree.lowestCommonAncestor(this.treeNode, new TreeNode(7, null, null), new TreeNode(4, null, null));

        System.out.println(result);
    }

}