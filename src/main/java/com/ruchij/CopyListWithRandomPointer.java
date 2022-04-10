package com.ruchij;

import java.util.HashMap;
import java.util.Map;

public class CopyListWithRandomPointer {
    static class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "val=" + val +
                    ", next=" + (next != null ? next.val : "null") +
                    ", random=" + (random != null ? random.val : "null") +
                    '}';
        }
    }

    public Node copyRandomList(Node input) {
        return copyRandomList(input, new HashMap<>());
    }

    private Node copyRandomList(Node input, Map<Node, Node> visited) {
        if (input == null) {
            return null;
        } else {
            Node existing = visited.get(input);

            if (existing != null) {
                return existing;
            } else {
                Node node = new Node(input.val);

                visited.put(input, node);

                node.next = copyRandomList(input.next, visited);
                node.random = copyRandomList(input.random, visited);

                return node;
            }
        }
    }


}
