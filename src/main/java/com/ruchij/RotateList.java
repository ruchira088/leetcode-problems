package com.ruchij;

import java.util.Objects;

public class RotateList {
    static final class ListNode {
        private int val;
        private ListNode next;

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }

        public int val() {
            return val;
        }

        public ListNode next() {
            return next;
        }

        @Override
        public boolean equals(Object obj) {
            if (obj == this) return true;
            if (obj == null || obj.getClass() != this.getClass()) return false;
            var that = (ListNode) obj;
            return this.val == that.val &&
                    Objects.equals(this.next, that.next);
        }

        @Override
        public int hashCode() {
            return Objects.hash(val, next);
        }

        @Override
        public String toString() {
            return "ListNode[" +
                    "val=" + val + ", " +
                    "next=" + next + ']';
        }
    }

    public ListNode rotateRight(ListNode head, int k) {
        ListNode current = head;
        int listSize = size(head);

        if (listSize == 0) {
            return head;
        }

        int offset = listSize - k % listSize;

        ListNode listNode = new ListNode(0, null);
        ListNode result = listNode;
        int index = 0;

        while (index < offset) {
            current = current.next;
            index++;
        }

        while (index < listSize) {
            listNode.next = new ListNode(current.val, null);
            listNode = listNode.next;
            current = current.next;
            index++;
        }

        index = 0;

        while (index < offset) {
            listNode.next = new ListNode(head.val, null);
            listNode = listNode.next;
            head = head.next;
            index++;
        }

        return result.next;
    }

    private int size(ListNode listNode) {
        int count = 0;

        while (listNode != null) {
            count++;
            listNode = listNode.next;
        }

        return count;
    }
}
