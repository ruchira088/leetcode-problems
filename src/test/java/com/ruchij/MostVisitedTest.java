package com.ruchij;

import org.junit.jupiter.api.Test;

class MostVisitedTest {
    private final MostVisited mostVisited = new MostVisited();

    @Test
    void testOne() {
        String[] usernames = {"dowg", "dowg", "dowg"};
        String[] websites = {"y", "loedo", "y"};
        int[] timestamps = {158931262, 562600350, 148438945};

        System.out.println(mostVisited.mostVisitedPattern(usernames, timestamps, websites));
    }

    @Test
    void testTwo() {
        String[] usernames = {"h","eiy","cq","h","cq","txldsscx","cq","txldsscx","h","cq","cq"};
        String[] websites = {"hibympufi","hibympufi","hibympufi","hibympufi","hibympufi","hibympufi","hibympufi","hibympufi","yljmntrclw","hibympufi","yljmntrclw"};
        int[] timestamps = {527896567,334462937,517687281,134127993,859112386,159548699,51100299,444082139,926837079,317455832,411747930};

        System.out.println(mostVisited.mostVisitedPattern(usernames, timestamps, websites));
    }

}