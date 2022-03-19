package com.ruchij;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

class WordLadderTest {
    private final WordLadder wordLadder = new WordLadder();

    @Test
    void testOne() {
        Assertions.assertEquals(
                5,
                wordLadder.ladderLength(
                        "hit",
                        "cog",
                        List.of("hot", "dot", "dog", "lot", "log", "cog")
                )
        );
    }

    @Test
    void testTwo() {
        Assertions.assertEquals(
                0,
                wordLadder.ladderLength(
                        "hit",
                        "cog",
                        List.of("hot", "dot", "dog", "lot", "log")
                )
        );
    }

}