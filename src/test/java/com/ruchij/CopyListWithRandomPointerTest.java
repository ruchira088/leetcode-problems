package com.ruchij;

import com.ruchij.CopyListWithRandomPointer.Node;
import org.junit.jupiter.api.Test;

class CopyListWithRandomPointerTest {
    private final CopyListWithRandomPointer copyListWithRandomPointer = new CopyListWithRandomPointer();

    @Test
    void testOne() {
        Node one = new Node(1);
        Node two = new Node(2);
        Node three = new Node(3);
        Node four = new Node(4);

        one.next = two;
        one.random = three;

        two.next = three;
        two.random = four;

        three.next = four;
        three.random = two;

        four.random = one;

        Node node = copyListWithRandomPointer.copyRandomList(one);

        System.out.println(node);
    }

}