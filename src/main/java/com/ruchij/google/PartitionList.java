package com.ruchij.google;

public class PartitionList {
    public class ListNode {
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
    }

    public ListNode partition(ListNode head, int x) {
        ListNode left = null;
        ListNode leftStart = null;
        ListNode right = null;
        ListNode rightStart = null;

        while (head != null) {
            int val = head.val;
            ListNode node = new ListNode(val);

            if (val < x) {
                if (leftStart == null) {
                    leftStart = node;
                } else {
                    left.next = node;
                }

                left = node;
            } else {
                if (rightStart == null) {
                    rightStart = node;
                } else {
                    right.next = node;
                }

                right = node;
            }

            head = head.next;
        }

        if (left != null) {
            left.next = rightStart;
        } else {
            leftStart = rightStart;
        }

        return leftStart;
    }
}
