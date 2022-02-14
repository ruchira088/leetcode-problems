package com.ruchij;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SubdomainVisitCountTest {
    private final SubdomainVisitCount subdomainVisitCount = new SubdomainVisitCount();

    @Test
    void testOne() {
        System.out.println(subdomainVisitCount.subdomainVisits(new String[]{ "9001 discuss.leetcode.com" }));
    }

}