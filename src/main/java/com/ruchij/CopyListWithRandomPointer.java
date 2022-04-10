package com.ruchij;

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
        Node node = new Node(-1);
        Node head = input;
        Node current = node;

        while (head != null) {
            current.next = new Node(head.val);
            current = current.next;
            head = head.next;
        }

        head = input;
        current = node.next;

        while (head != null) {
            Node random = head.random;

            if (random != null) {
                Node original = input;
                int index = 0;

                while (original != random) {
                    original = original.next;
                    index++;
                }

                int currentIndex = 0;

                Node updated = node.next;

                while (currentIndex != index) {
                    updated = updated.next;
                    currentIndex++;
                }

                current.random = updated;
            }

            head = head.next;
            current = current.next;
        }

        return node.next;
    }
}
