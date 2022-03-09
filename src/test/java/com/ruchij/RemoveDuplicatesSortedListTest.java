package com.ruchij;

import org.junit.jupiter.api.Test;
import com.ruchij.RemoveDuplicatesSortedList.ListNode;

import static org.junit.jupiter.api.Assertions.*;

class RemoveDuplicatesSortedListTest {
    private final RemoveDuplicatesSortedList removeDuplicatesSortedList = new RemoveDuplicatesSortedList();

    @Test
    void testOne() {
        ListNode listNode = new ListNode(1, new ListNode(1, new ListNode(1, new ListNode(2, new ListNode(3)))));
        ListNode result = removeDuplicatesSortedList.deleteDuplicates(listNode);
        System.out.println(result);
    }

    @Test
    void testTwo() {
        ListNode listNode = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(3, new ListNode(3)))));
        ListNode result = removeDuplicatesSortedList.deleteDuplicates(listNode);
        System.out.println(result);
    }

}