package com.ruchij;

import java.util.*;

public class SubdomainVisitCount {
    public List<String> subdomainVisits(String[] cpdomains) {
        Map<String, Integer> mappings = new HashMap<>();
        List<String> result = new ArrayList<>();

        for (String domain : cpdomains) {
            String[] strings = domain.split(" ");
            Integer count = Integer.valueOf(strings[0]);
            List<String> domains = parse(strings[1].trim());

            for (String parsedDomain : domains) {
                mappings.put(parsedDomain, mappings.getOrDefault(parsedDomain, 0) + count);
            }
        }

        for (Map.Entry<String, Integer> entry : mappings.entrySet()) {
            result.add(entry.getValue() + " " + entry.getKey());
        }

        return result;
    }

    private List<String> parse(String domain) {
        Stack<String> result = new Stack<>();
        String[] sub = domain.split("\\.");

        for (int i = sub.length - 1; i >= 0; i--) {
            if (result.isEmpty()) {
                result.add(sub[i]);
            } else {
                String last = result.peek();
                result.add(sub[i] + "." + last);
            }
        }

        return result.stream().toList();
    }
}
