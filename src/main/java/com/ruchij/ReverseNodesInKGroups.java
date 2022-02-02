package com.ruchij;

public class ReverseNodesInKGroups {
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

    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode dummy = new ListNode(0);
        ListNode result = dummy;
        ListNode groupStart = null;
        ListNode[] list = new ListNode[k];

        whileLoop:
        while (head != null) {
            groupStart = head;

            for (int i = 0; i < k; i++) {
                if (head == null) {
                    dummy.next = groupStart;
                    break whileLoop;
                }

                list[i] = head;
                head = head.next;
            }

            list[0].next = list[k - 1].next;

            for (int i = 0; i < k; i++) {
                dummy.next = list[k - 1 - i];
                dummy = dummy.next;
            }
        }

        return result.next;
    }
}
