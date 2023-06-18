package com.ruchij.canva;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class BestTeamTest {
    private final BestTeam bestTeam = new BestTeam();

    @Test
    void returnsExpectedResult() {
        Assertions.assertEquals(34, bestTeam.bestTeamScore(new int[]{1, 3, 5, 10, 15}, new int[]{1, 2, 3, 4, 5}));
        Assertions.assertEquals(16, bestTeam.bestTeamScore(new int[]{4, 5, 6, 5}, new int[]{2, 1, 2, 1}));
        Assertions.assertEquals(6, bestTeam.bestTeamScore(new int[]{1, 2, 3, 5}, new int[]{8, 9, 10, 1}));
        Assertions.assertEquals(3287, bestTeam.bestTeamScore(new int[]{596, 277, 897, 622, 500, 299, 34, 536, 797, 32, 264, 948, 645, 537, 83, 589, 770}, new int[]{18, 52, 60, 79, 72, 28, 81, 33, 96, 15, 18, 5, 17, 96, 57, 72, 72}));
    }
}