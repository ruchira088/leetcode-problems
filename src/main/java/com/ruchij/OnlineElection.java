package com.ruchij;

import java.util.*;

public class OnlineElection {
    public class TopVotedCandidate {
        record Vote(int count, int index) {}

        private final int[] times;
        private final ArrayList<Integer> winners;


        public TopVotedCandidate(int[] persons, int[] times) {
            this.times = times;

            Map<Integer, Vote> votes = new HashMap<>();
            LinkedList<Integer> winners = new LinkedList<>();

            for (int i = 0; i < persons.length; i++) {
                int person = persons[i];
                Vote currentVote = votes.getOrDefault(person, new Vote(0, 0));
                votes.put(person, new Vote(currentVote.count + 1, i));
                int winner = findWinner(votes);
                winners.addLast(winner);
            }

            this.winners = new ArrayList<>(winners);
        }

        private int findWinner(Map<Integer, Vote> votes) {
            Comparator<Map.Entry<Integer, Vote>> comparatorOne =
                    Comparator.comparingInt(entry -> entry.getValue().count);

            Comparator<Map.Entry<Integer, Vote>> comparatorTwo =
                    Comparator.comparingInt(entry -> entry.getValue().index);

            return votes.entrySet().stream()
                    .max(comparatorOne.thenComparing(comparatorTwo))
                    .map(Map.Entry::getKey)
                    .orElse(0);
        }

        public int q(int t) {
            int index = Arrays.binarySearch(times, t);

            if (index >= 0) {
                return winners.get(index);
            } else {
                return winners.get(-index - 2);
            }
        }
    }
}
