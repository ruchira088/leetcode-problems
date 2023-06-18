package com.ruchij.canva;

import java.util.*;

public class BestTeam {
    record Player(int age, int score) {}

    public int bestTeamScore(int[] scores, int[] ages) {
        Comparator<Player> ageComparator = Comparator.comparing(Player::age);
        Comparator<Player> scoreComparator = Comparator.comparing(Player::score);

        Player[] players = new Player[scores.length];
        int[] teamScores = new int[scores.length];

        for (int i = 0; i < scores.length; i++) {
            Player player = new Player(ages[i], scores[i]);
            players[i] = player;
        }

        Arrays.sort(players, ageComparator.thenComparing(scoreComparator));

        for (int i = 0; i < players.length; i++) {
            Player player = players[i];
            teamScores[i] = player.score;

            for (int j = i - 1; j >= 0; j--) {
                if (players[j].score <= player.score) {
                    teamScores[i] = Math.max(teamScores[i], teamScores[j] + player.score);
                }
            }
        }

        return Arrays.stream(teamScores).max().getAsInt();

    }
}
