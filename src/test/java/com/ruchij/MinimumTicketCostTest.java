package com.ruchij;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MinimumTicketCostTest {
    private final MinimumTicketCost minimumTicketCost = new MinimumTicketCost();

    @Test
    void testOne() {
        assertEquals(11, minimumTicketCost.mincostTickets(new int[]{1, 4, 6, 7, 8, 20}, new int[]{2, 7, 15}));
    }

    @Test
    void testTwo() {
        assertEquals(17, minimumTicketCost.mincostTickets(new int[]{1,2,3,4,5,6,7,8,9,10,30,31}, new int[]{2, 7, 15}));
    }

}