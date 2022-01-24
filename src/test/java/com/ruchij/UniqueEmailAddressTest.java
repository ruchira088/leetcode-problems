package com.ruchij;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class UniqueEmailAddressTest {
    private final UniqueEmailAddress uniqueEmailAddress = new UniqueEmailAddress();

    @Test
    void testOne() {
        String[] emails = {"alicez@leetcode.com", "alice.z@leetcode.com", "m.y+name@email.com", "my@email.com"};
        int count = uniqueEmailAddress.numUniqueEmails(emails);

        Assertions.assertEquals(2, count);
    }

}