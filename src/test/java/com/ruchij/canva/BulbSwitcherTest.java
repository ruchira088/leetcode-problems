package com.ruchij.canva;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class BulbSwitcherTest {
    private final BulbSwitcher bulbSwitcher = new BulbSwitcher();

    @Test
    void returnsExpectedResult() {
        Assertions.assertEquals(1, bulbSwitcher.bulbSwitch(3));
        Assertions.assertEquals(0, bulbSwitcher.bulbSwitch(0));
        Assertions.assertEquals(1, bulbSwitcher.bulbSwitch(1));

        HashMap<Integer, List<Integer>> results = new HashMap<>();

        for (int i = 0; i < 1000; i++) {
            int bulbSwitch = bulbSwitcher.bulbSwitch(i);
            results.computeIfAbsent(bulbSwitch, __ -> new ArrayList<>()).add(i);
            System.out.println("%s -> %s".formatted(i, bulbSwitch));
        }

        System.out.println(results);

        for (Map.Entry<Integer, List<Integer>> entry : results.entrySet()) {
            System.out.println("%s -> %s".formatted(entry.getKey(), entry.getValue().size()));
        }
    }

}