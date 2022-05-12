package com.ruchij;

public class BinarySearchTreeToSortedDoublyLinkedList {
    static final class Node {
        private int val;
        private Node left;
        private Node right;

        Node(int val, Node left, Node right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }

        @Override
        public String toString() {
            return "Node[" +
                    "val=" + val + ", " +
                    "left=" + left + ", " +
                    "right=" + right + ']';
        }
    }

    public Node treeToDoublyList(Node root) {
        if (root == null) {
            return null;
        }

        Node dummy = new Node(0, null, null);
        Node last = treeToDoublyList(root, dummy);
        Node start = dummy.right;

        start.left = last;
        last.right = start;

        return start;
    }

    public Node treeToDoublyList(Node node, Node result) {
        if (node.left != null) {
            result = treeToDoublyList(node.left, result);
        }

        result.right = node;
        node.left = result;
        result = node;

        if (node.right != null) {
            result = treeToDoublyList(node.right, result);
        }

        return result;
    }

}
