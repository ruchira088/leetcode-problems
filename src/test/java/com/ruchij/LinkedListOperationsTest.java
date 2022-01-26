package com.ruchij;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

class LinkedListOperationsTest {
    private final LinkedListOperations linkedListOperations = new LinkedListOperations();

    @Test
    void reverseTest() {
        LinkedListOperations.MyLinkedList<Integer> list = linkedListOperations.fromList(List.of(1, 2, 3, 4, 5));

        Assertions.assertEquals(List.of(5, 4, 3, 2, 1), linkedListOperations.toList(linkedListOperations.reverse(list)));
        Assertions.assertEquals(List.of(1, 2, 3, 4, 5), linkedListOperations.toList(linkedListOperations.clone(list)));
    }

}