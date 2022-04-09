package com.ruchij;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SimplifyPathTest {
    private final SimplifyPath simplifyPath = new SimplifyPath();

    @Test
    void testOne() {
        assertEquals("/home", simplifyPath.simplifyPath("/home/"));
    }

    @Test
    void testTwo() {
        assertEquals("/", simplifyPath.simplifyPath("/../"));
    }

    @Test
    void testThree() {
        assertEquals("/home/foo", simplifyPath.simplifyPath("/home//foo/"));
    }

    @Test
    void testFour() {
        assertEquals("/c", simplifyPath.simplifyPath("/a/./b/../../c/"));
    }

}