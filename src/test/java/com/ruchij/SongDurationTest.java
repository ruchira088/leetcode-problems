package com.ruchij;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SongDurationTest {
    private final SongDuration songDuration = new SongDuration();

    @Test
    void testOne() {
        assertEquals(3, songDuration.numPairsDivisibleBy60(new int[]{30, 20, 150, 100, 40}));
        assertEquals(3, songDuration.numPairsDivisibleBy60(new int[]{60, 60, 60}));
    }

}