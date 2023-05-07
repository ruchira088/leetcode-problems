package com.ruchij;

import java.util.*;
import java.util.stream.Collectors;

public class RankTeamsByVotes {
    public String rankTeams(String[] votes) {
        return rankTeams(parseVotes(votes));
    }

    Map<Character, Map<Integer, Integer>> parseVotes(String[] votes) {
        Map<Character, Map<Integer, Integer>> votesTally = new HashMap<>();

        for (String vote : votes) {
            char[] voteCharArray = vote.toCharArray();

            for (int i = 0; i < voteCharArray.length; i++) {
                Map<Integer, Integer> votesForTeam =
                        votesTally.computeIfAbsent(voteCharArray[i], __ -> new HashMap<>());

                votesForTeam.put(i, votesForTeam.getOrDefault(i, 0) + 1);
            }
        }

        return votesTally;
    }

    String rankTeams(Map<Character, Map<Integer, Integer>> votes) {
        List<Map.Entry<Character, Map<Integer, Integer>>> rankedTeams = votes.entrySet().stream()
                .sorted(new VoteComparator().reversed())
                .toList();


        String ranks = rankedTeams.stream().map(value -> value.getKey().toString())
                .collect(Collectors.joining());

        return ranks;
    }

    class VoteComparator implements Comparator<Map.Entry<Character, Map<Integer, Integer>>> {
        @Override
        public int compare(Map.Entry<Character, Map<Integer, Integer>> entryA, Map.Entry<Character, Map<Integer, Integer>> entryB) {
            Map<Integer, Integer> votesA = entryA.getValue();
            Map<Integer, Integer> votesB = entryB.getValue();

            HashSet<Integer> ranks = new HashSet<>(votesA.keySet());
            ranks.addAll(votesB.keySet());

            int positions =
                    ranks.stream().max(Comparator.naturalOrder()).orElse(0);

            for (int i = 0; i < positions; i++) {
                Integer valueA = votesA.getOrDefault(i, 0);
                Integer valueB = votesB.getOrDefault(i, 0);

                if (!Objects.equals(valueA, valueB)) {
                    return valueA.compareTo(valueB);
                }
            }

            return -entryA.getKey().compareTo(entryB.getKey());
        }
    }
}
