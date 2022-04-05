package com.ruchij;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ReorderDataLogsTest {

    private ReorderDataLogs reorderDataLogs = new ReorderDataLogs();

    @Test
    void testOne() {
        String[] strings =
                reorderDataLogs.reorderLogFiles(new String[]{"dig1 8 1 5 1", "let1 art can", "dig2 3 6", "let2 own kit dig", "let3 art zero"});

        assertArrayEquals(new String[]{"let1 art can", "let3 art zero", "let2 own kit dig", "dig1 8 1 5 1", "dig2 3 6"}, strings);
    }

    @Test
    void testTwo() {
        String[] strings =
                reorderDataLogs.reorderLogFiles(new String[]{"a1 9 2 3 1", "g1 act car", "zo4 4 7", "ab1 off key dog", "a8 act zoo"});

        assertArrayEquals(new String[]{"g1 act car", "a8 act zoo", "ab1 off key dog", "a1 9 2 3 1", "zo4 4 7"}, strings);
    }

    @Test
    void testThree() {
        String[] strings =
                reorderDataLogs.reorderLogFiles(new String[]{"a1 9 2 3 1","g1 act car","zo4 4 7","ab1 off key dog","a8 act zoo","a2 act car"});

        assertArrayEquals(new String[]{"a2 act car","g1 act car","a8 act zoo","ab1 off key dog","a1 9 2 3 1","zo4 4 7"}, strings);
    }

}