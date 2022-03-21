package com.ruchij;

import org.junit.jupiter.api.Test;

import static com.ruchij.SerializeDeserializeBinaryTree.TreeNode;

class SerializeDeserializeBinaryTreeTest {
    private final SerializeDeserializeBinaryTree.Codec codec = new SerializeDeserializeBinaryTree.Codec();

    @Test
    void testOne() {
        TreeNode treeNode = new TreeNode(1, new TreeNode(2), new TreeNode(3, new TreeNode(4), new TreeNode(5)));
        String serialize = codec.serialize(treeNode);

        System.out.println(serialize);

        System.out.println(codec.deserialize(serialize));
    }

}