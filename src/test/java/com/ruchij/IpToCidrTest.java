package com.ruchij;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class IpToCidrTest {
    private final IpToCidr ipToCidr = new IpToCidr();

    @Test
    void add() {
        assertEquals(List.of(255, 0, 0, 8), ipToCidr.add(List.of(255, 0, 0, 7), 1, 256));
        assertEquals(List.of(255, 0, 1, 0), ipToCidr.add(List.of(255, 0, 0, 255), 1, 256));
        assertEquals(List.of(255, 1, 0, 0), ipToCidr.add(List.of(255, 0, 255, 255), 1, 256));
    }

    @Test
    void testOne() {
        System.out.println(ipToCidr.ipToCIDR("255.0.0.7", 10));
    }

}