package com.ruchij;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PlusOne {
    public int[] plusOne(int[] digits) {
        List<Integer> result = new ArrayList<>();
        int carry = 1;

        for (int i = digits.length - 1; i >= 0; i--) {
            int number = digits[i] + carry;

            if (number > 9) {
                carry = 1;
                result.add(number % 10);
            } else {
                carry = 0;
                result.add(number);
            }
        }

        if (carry != 0) {
            result.add(carry);
        }


        Collections.reverse(result);

        return result.stream().mapToInt(x ->  x).toArray();
    }
}
