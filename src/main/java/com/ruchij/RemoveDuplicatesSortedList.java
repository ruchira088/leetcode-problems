package com.ruchij;

public class RemoveDuplicatesSortedList {
    static class ListNode {
        int val;
        ListNode next;

        ListNode(int val) {
            this(val, null);
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

    public ListNode deleteDuplicates(ListNode head) {
        ListNode result = new ListNode(-1);
        ListNode current = result;
        ListNode previous = null;
        Integer duplicate = null;

        while (head != null) {
            if (previous != null) {
                if (previous.val != head.val && (duplicate == null || duplicate != previous.val)) {
                    current.next = new ListNode(previous.val);
                    current = current.next;
                } else {
                    duplicate = previous.val;
                }
            }

            previous = head;
            head = head.next;
        }

        if (previous != null && (duplicate == null || duplicate != previous.val)) {
            current.next = new ListNode(previous.val);
        }

        return result.next;
    }
}
