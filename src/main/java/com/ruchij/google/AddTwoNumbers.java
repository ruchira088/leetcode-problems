package com.ruchij.google;

public class AddTwoNumbers {
    public static class ListNode {
        int val;
        ListNode next;

        public ListNode() {
        }

        public ListNode(int val) {
            this.val = val;
        }

        public ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }

        @Override
        public String toString() {
            StringBuilder stringBuilder = new StringBuilder();

            if (next != null) {
                stringBuilder.append(next);
            }

            stringBuilder.append(val);

            return stringBuilder.toString();
        }
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode result = null;
        ListNode current = null;
        int carry = 0;

        while (l1 != null || l2 != null) {
            int one = l1 != null ? l1.val : 0;
            int two = l2 != null ? l2.val : 0;

            int sum = one + two + carry;
            int val = sum % 10;
            carry = sum / 10;

            if (result == null) {
                result = new ListNode(val);
                current = result;
            } else {
                current.next = new ListNode(val);
                current = current.next;
            }

            if (l1 != null) {
                l1 = l1.next;
            }

            if (l2 != null) {
                l2 = l2.next;
            }
        }

        if (carry != 0) {
            current.next = new ListNode(carry);
        }

        return result;
    }
}
