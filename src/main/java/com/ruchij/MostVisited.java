package com.ruchij;

import java.util.*;

public class MostVisited {
    record Visit(String website, int timestamp) {
    }

    record Pattern(String siteOne, String siteTwo, String siteThree) implements Comparable<Pattern> {
        @Override
        public int compareTo(Pattern o) {
            return Comparator.comparing(Pattern::siteOne).thenComparing(Comparator.comparing(Pattern::siteTwo)).thenComparing(Comparator.comparing(Pattern::siteThree)).compare(this, o);
        }
    }

    public List<String> mostVisitedPattern(String[] username, int[] timestamp, String[] website) {
        Map<String, PriorityQueue<Visit>> visitors = new HashMap<>();
        Map<Pattern, Integer> count = new HashMap<>();

        for (int i = 0; i < username.length; i++) {
            String name = username[i];
            int time = timestamp[i];
            String site = website[i];

            PriorityQueue<Visit> queue = visitors.computeIfAbsent(name, key -> new PriorityQueue<Visit>(Comparator.comparingInt(Visit::timestamp)));
            queue.add(new Visit(site, time));
        }

        for (Map.Entry<String, PriorityQueue<Visit>> entry : visitors.entrySet()) {
            PriorityQueue<Visit> queue = entry.getValue();
            String[] values = new String[queue.size()];
            int i = 0;

            while (!entry.getValue().isEmpty()) {
                values[i] = queue.poll().website;
                i++;
            }

            consolidate(values, count);
        }

        Optional<Map.Entry<Pattern, Integer>> first = count.entrySet().stream()
                .sorted(Comparator.comparingInt(entry -> ((Map.Entry<Pattern, Integer>) entry).getValue()).reversed().thenComparing(entry -> ((Map.Entry<Pattern, Integer>) entry).getKey()))
                .findFirst();

        Pattern pattern = first.get().getKey();

        return List.of(pattern.siteOne, pattern.siteTwo, pattern.siteThree);
    }

    private void consolidate(String[] sites, Map<Pattern, Integer> count) {
        int size = sites.length;

        HashSet<Pattern> added = new HashSet<>();

        for (int a = 0; a < size; a++) {
            for (int b = a + 1; b < size; b++) {
                for (int c = b + 1; c < size; c++) {
                    Pattern pattern = new Pattern(sites[a], sites[b], sites[c]);
                    if (!added.contains(pattern)) {
                        count.put(pattern, count.getOrDefault(pattern, 0) + 1);
                        added.add(pattern);
                    }
                }
            }
        }
    }
}
