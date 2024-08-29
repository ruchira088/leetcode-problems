package com.ruchij.google;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Random;

class AddTwoNumbersTest {
    private static final AddTwoNumbers addTwoNumbers = new AddTwoNumbers();

    @Test
    void verifyResults() {
        Random random = new Random();
        for (int i = 0; i < 1000; i++) {
            Integer one = random.nextInt(0, 1000000);
            Integer two = random.nextInt(0, 1000000);
            Integer sum = one + two;

            Assertions.assertEquals(
                    sum.toString(),
                    addTwoNumbers.addTwoNumbers(parse(one.toString()), parse(two.toString())).toString()
            );

        }

        Assertions.assertEquals(
                "807",
                addTwoNumbers.addTwoNumbers(parse("342"), parse("465")).toString()
        );
    }

    private static AddTwoNumbers.ListNode parse(String number) {
        AddTwoNumbers.ListNode result = null;

        for (int i = 0; i < number.length(); i++) {
            int value = Character.getNumericValue(number.charAt(i));
            result = new AddTwoNumbers.ListNode(value, result);
        }

        return result;
    }
}