package com.ruchij.google;

public class ReverseLinkedList2 {
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
    }

    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode current = head;
        ListNode start = null;
        ListNode last = null;
        ListNode list = null;
        int position = 1;

        while (current != null) {
            int value = current.val;

            if (list == null && position == left) {
                list = new ListNode(value);
                last = list;
            } else if (list != null) {
                list = new ListNode(value, list);
            }

            if (start != null && position == right) {
                start.next = list;
                last.next = current.next;

                return head;
            } else if (last != null && position == right) {
                last.next = current.next;
                return list;
            }

            if (list == null) {
                start = current;
            }

            current = current.next;
            position++;
        }


        return head;
    }
}
