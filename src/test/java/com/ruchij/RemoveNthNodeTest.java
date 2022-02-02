package com.ruchij;

import org.junit.jupiter.api.Test;

class RemoveNthNodeTest {
    private final RemoveNthNode removeNthNode = new RemoveNthNode();

    @Test
    void testOne() {
        RemoveNthNode.ListNode listNode =
                new RemoveNthNode.ListNode(1, new RemoveNthNode.ListNode(2, new RemoveNthNode.ListNode(3, new RemoveNthNode.ListNode(4, new RemoveNthNode.ListNode(5)))));

        RemoveNthNode.ListNode result = removeNthNode.removeNthFromEnd(listNode, 2);

        System.out.println(result);
    }

    @Test
    void testTwo() {
        RemoveNthNode.ListNode listNode =
                new RemoveNthNode.ListNode(1);

        RemoveNthNode.ListNode result = removeNthNode.removeNthFromEnd(listNode, 1);

        System.out.println(result);
    }

}