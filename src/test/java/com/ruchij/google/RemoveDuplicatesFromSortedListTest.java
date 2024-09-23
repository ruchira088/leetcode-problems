package com.ruchij.google;

import com.ruchij.google.RemoveDuplicatesFromSortedList.ListNode;
import org.junit.jupiter.api.Test;

class RemoveDuplicatesFromSortedListTest {
    private static final RemoveDuplicatesFromSortedList removeDuplicates = new RemoveDuplicatesFromSortedList();

    @Test
    void verifyResult() {
        removeDuplicates.deleteDuplicates(new ListNode(1, new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(3))))));
    }

}