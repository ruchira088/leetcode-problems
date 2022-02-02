package com.ruchij;

public class MergeLinkedLists {
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

    public ListNode mergeTwoListsRe(ListNode list1, ListNode list2) {
        if (list1 == null) {
            return list2;
        } else if (list2 == null) {
            return list1;
        } else {
            int first = list1.val;
            int second = list2.val;

            if (first < second) {
                return new ListNode(first, mergeTwoListsRe(list1.next, list2));
            } else {
                return new ListNode(second, mergeTwoListsRe(list1, list2.next));
            }
        }
    }

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode dummy = new ListNode(0, null);
        ListNode head = dummy;

        while (list1 != null || list2 != null) {
            if (list1 == null) {
                dummy.next = list2;
                break;
            } else if (list2 == null) {
                dummy.next = list1;
                break;
            } else {
                int first = list1.val;
                int second = list2.val;

                if (first < second) {
                    dummy.next = new ListNode(first);
                    list1 = list1.next;
                } else {
                    dummy.next = new ListNode(second);
                    list2 = list2.next;
                }

                dummy = dummy.next;
            }
        }

        return head.next;
    }
}
