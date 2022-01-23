package com.ruchij;

import java.util.HashSet;
import java.util.Set;

public class LinkedListCycle {
    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x, ListNode listNode) {
            val = x;
            next = listNode;
        }
    }

    public boolean hasCycle(ListNode head) {
        Set<ListNode> set = new HashSet<>();

        while (head != null) {
            if (set.contains(head)) {
                return true;
            } else {
                set.add(head);
                head = head.next;
            }
        }

        return false;
    }
}
