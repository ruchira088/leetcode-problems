package com.ruchij;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Map;

class RankTeamsByVotesTest {

    @Test
    void parsingVotes() {
        RankTeamsByVotes rankTeamsByVotes = new RankTeamsByVotes();
        Map<Character, Map<Integer, Integer>> votes = rankTeamsByVotes.parseVotes(new String[]{"ABC", "ACB", "ABC", "ACB", "ACB"});

        System.out.println(votes);
    }

    @Test
    void rankingsTeams() {
        RankTeamsByVotes rankTeamsByVotes = new RankTeamsByVotes();
        Assertions.assertEquals("ACB", rankTeamsByVotes.rankTeams(new String[]{"ABC","ACB","ABC","ACB","ACB"}));

        Assertions.assertEquals("XWYZ", rankTeamsByVotes.rankTeams(new String[]{"WXYZ","XYZW"}));

        Assertions.assertEquals("ABC", rankTeamsByVotes.rankTeams(new String[]{"BCA","CAB","CBA","ABC","ACB","BAC"}));
    }

}