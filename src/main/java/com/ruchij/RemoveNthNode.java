package com.ruchij;

public class RemoveNthNode {
    public static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }

        @Override
        public String toString() {
            return "ListNode{" +
                    "val=" + val +
                    ", next=" + next +
                    '}';
        }
    }

    public ListNode removeNthFromEnd(ListNode head, int n) {
        int size = length(head);
        ListNode listNode = head;
        int index = size - n;
        int current = 0;

        while (current <= index) {
            if (index == 0) {
                return head.next;
            } else if (current == index - 1) {
                head.next = head.next.next;
                return listNode;
            } else {
                head = head.next;
                current++;
            }
        }

        return listNode;
    }

    private int length(ListNode head) {
        int length = 0;
        while (head != null) {
            length++;
            head = head.next;
        }

        return length;
    }
}
