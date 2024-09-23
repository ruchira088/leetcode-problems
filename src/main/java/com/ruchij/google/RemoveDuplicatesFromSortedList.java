package com.ruchij.google;

public class RemoveDuplicatesFromSortedList {
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

    public ListNode deleteDuplicatesOne(ListNode head) {
        ListNode current = head;

        while (current != null && current.next != null) {
            if (current.val == current.next.val) {
                current.next = current.next.next;
            } else {
                current = current.next;
            }
        }

        return head;
    }

    public ListNode deleteDuplicates(ListNode head) {
        if (head != null) {
            ListNode result = head;
            ListNode current = head.next;

            while (current != null) {
                if (result.val != current.val) {
                    result.next = current;
                    result = result.next;
                }

                current = current.next;
            }

            result.next = null;
        }

        return head;
    }

    public ListNode deleteDuplicatesSimple(ListNode head) {
        int lastValue = 0;
        ListNode start = null;
        ListNode current = null;

        while (head != null) {
            if (start == null) {
                start = new ListNode(head.val);
                current = start;
            } else if (lastValue != head.val) {
                current.next = new ListNode(head.val);
                current = current.next;
            }

            lastValue = head.val;
            head = head.next;

        }

        return start;
    }


}
