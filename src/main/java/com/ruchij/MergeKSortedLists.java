package com.ruchij;

public class MergeKSortedLists {
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

    public ListNode mergeKLists(ListNode[] lists) {
        ListNode listNode = new ListNode(0, null);
        ListNode head = listNode;
        boolean loop = true;

        while (loop) {
            loop = false;
            Integer minimum = null;
            Integer index = null;
            for (int i = 0; i < lists.length; i++) {
                if (lists[i] != null) {
                    if (minimum == null || minimum > lists[i].val) {
                        minimum = lists[i].val;
                        index = i;
                        loop = true;
                    }
                }
            }

            if (minimum != null) {
                listNode.next = new ListNode(minimum);
                listNode = listNode.next;

                lists[index] = lists[index].next;
            }
        }

        return head.next;
    }
}
