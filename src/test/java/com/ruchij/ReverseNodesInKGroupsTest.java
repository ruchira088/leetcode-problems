package com.ruchij;

import org.junit.jupiter.api.Test;

class ReverseNodesInKGroupsTest {
    private final ReverseNodesInKGroups reverseNodesInKGroups = new ReverseNodesInKGroups();

    @Test
    void testOne() {
        ReverseNodesInKGroups.ListNode input =
                new ReverseNodesInKGroups.ListNode(1, new ReverseNodesInKGroups.ListNode(2, new ReverseNodesInKGroups.ListNode(3, new ReverseNodesInKGroups.ListNode(4, new ReverseNodesInKGroups.ListNode(5)))));

        System.out.println(reverseNodesInKGroups.reverseKGroup(input, 2));
    }

}