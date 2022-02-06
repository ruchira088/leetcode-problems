package com.ruchij;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class DuplicateSubTrees {
    record TreeNode(int val, TreeNode left, TreeNode right) {}
    record MyTreeNode(int val, MyTreeNode left, MyTreeNode right) {}

    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        MyTreeNode myTreeNode = duplicate(root);
        HashSet<MyTreeNode> duplicates = new HashSet<>();
        findDuplicates(myTreeNode, new HashSet<>(), duplicates);

        ArrayList<TreeNode> result = new ArrayList<>();

        for (MyTreeNode node: duplicates) {
            result.add(duplicate(node));
        }

        return result;
    }

    void findDuplicates(MyTreeNode myTreeNode, Set<MyTreeNode> visited, Set<MyTreeNode> duplicates) {
        if (myTreeNode != null) {
            if (visited.contains(myTreeNode)) {
                duplicates.add(myTreeNode);
            } else {
                visited.add(myTreeNode);
            }

            findDuplicates(myTreeNode.left, visited, duplicates);
            findDuplicates(myTreeNode.right, visited, duplicates);
        }
    }

    MyTreeNode duplicate(TreeNode treeNode) {
        if (treeNode == null) {
            return null;
        } else {
            return new MyTreeNode(treeNode.val, duplicate(treeNode.left), duplicate(treeNode.right));
        }
    }

    TreeNode duplicate(MyTreeNode myTreeNode) {
        if (myTreeNode == null) {
            return null;
        } else {
            return new TreeNode(myTreeNode.val, duplicate(myTreeNode.left), duplicate(myTreeNode.right));
        }
    }


}
