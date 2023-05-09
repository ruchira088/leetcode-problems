package com.ruchij;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class OnlineElectionTest {

    @Test
    void returnsExpectedResult() {
        OnlineElection onlineElection = new OnlineElection();
        OnlineElection.TopVotedCandidate topVotedCandidate =
                onlineElection.new TopVotedCandidate(new int[]{0, 1, 1, 0, 0, 1, 0}, new int[]{0, 5, 10, 15, 20, 25, 30});

        Assertions.assertEquals(0, topVotedCandidate.q(3));
        Assertions.assertEquals(1, topVotedCandidate.q(12));
        Assertions.assertEquals(1, topVotedCandidate.q(25));
        Assertions.assertEquals(0, topVotedCandidate.q(15));
        Assertions.assertEquals(0, topVotedCandidate.q(24));
        Assertions.assertEquals(1, topVotedCandidate.q(8));
    }


    @Test
    void testCase9() {
        OnlineElection onlineElection = new OnlineElection();
        OnlineElection.TopVotedCandidate topVotedCandidate =
                onlineElection.new TopVotedCandidate(new int[]{0,0,0,0,1}, new int[]{0,6,39,52,75});

        Assertions.assertEquals(0, topVotedCandidate.q(45));
        Assertions.assertEquals(0, topVotedCandidate.q(49));
        Assertions.assertEquals(0, topVotedCandidate.q(59));
        Assertions.assertEquals(0, topVotedCandidate.q(68));
        Assertions.assertEquals(0, topVotedCandidate.q(42));
        Assertions.assertEquals(0, topVotedCandidate.q(37));
        Assertions.assertEquals(0, topVotedCandidate.q(99));
        Assertions.assertEquals(0, topVotedCandidate.q(26));
        Assertions.assertEquals(0, topVotedCandidate.q(78));
        Assertions.assertEquals(0, topVotedCandidate.q(43));
    }

}