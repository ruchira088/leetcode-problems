package com.ruchij;

import org.junit.jupiter.api.Test;

import java.util.List;

class AddTwoNumbersTest {

    @Test
    void shouldReturnExpectedResult() {
        AddTwoNumbers addTwoNumbers = new AddTwoNumbers();
        AddTwoNumbers.ListNode l1 = listNode(List.of(9,9,9,9,9,9,9));
        AddTwoNumbers.ListNode l2 = listNode(List.of(9,9,9,9));

        AddTwoNumbers.ListNode result = addTwoNumbers.addTwoNumbers(l1, l2);

        System.out.println(prettyPrint(result));
    }

    AddTwoNumbers.ListNode listNode(List<Integer> numbers) {
        if (numbers.isEmpty()) {
            return null;
        } else {
            return new AddTwoNumbers.ListNode(numbers.get(0), listNode(numbers.subList(1, numbers.size())));
        }
    }

    String prettyPrint(AddTwoNumbers.ListNode listNode) {
        StringBuilder stringBuilder = new StringBuilder();

        while (listNode != null) {
            stringBuilder.append(listNode.val);
            listNode = listNode.next;
        }

        return stringBuilder.toString();
    }


}