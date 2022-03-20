package com.ruchij;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class VerticalOrderTraversalBinaryTree {
    record TreeNode(int val, TreeNode left, TreeNode right) {}
    record Coordinate(int x, int y) {}
    record Node(int val, Coordinate coordinate) {}

    public List<List<Integer>> verticalTraversal(TreeNode root) {
        List<Node> nodes = new ArrayList<>();
        traverse(new Coordinate(0, 0), nodes, root);
        nodes.sort(
                Comparator.comparingInt(node -> ((Node) node).coordinate.x)
                        .thenComparingInt(node -> ((Node) node).coordinate.y)
                        .thenComparingInt(node -> ((Node) node).val)
        );
        List<List<Integer>> results = new ArrayList<>();

        Integer x = null;
        List<Integer> group = new ArrayList<>();

        for (Node node : nodes) {
            if (x != null && x != node.coordinate.x) {
                results.add(group);
                group = new ArrayList<>();
            }

            x = node.coordinate.x;
            group.add(node.val);
        }

        if (!group.isEmpty()) {
            results.add(group);
        }

        return results;
    }

    public void traverse(Coordinate coordinate, List<Node> nodes, TreeNode treeNode) {
        if (treeNode != null) {
            nodes.add(new Node(treeNode.val, coordinate));

            traverse(new Coordinate(coordinate.x - 1, coordinate.y + 1), nodes, treeNode.left);
            traverse(new Coordinate(coordinate.x + 1, coordinate.y + 1), nodes, treeNode.right);
        }
    }
}
