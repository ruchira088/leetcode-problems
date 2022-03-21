package com.ruchij;

import org.junit.jupiter.api.Test;

import static com.ruchij.DesignHitCounter.HitCounter;
import static org.junit.jupiter.api.Assertions.assertEquals;

class DesignHitCounterTest {

    @Test
    void testOne() {
        HitCounter hitCounter = new HitCounter();
        hitCounter.hit(2);
        hitCounter.hit(3);
        hitCounter.hit(4);
        assertEquals(3, hitCounter.getHits(300));
        assertEquals(3, hitCounter.getHits(301));
        assertEquals(2, hitCounter.getHits(302));
        assertEquals(1, hitCounter.getHits(303));
        assertEquals(0, hitCounter.getHits(304));
        hitCounter.hit(501);
        assertEquals(1, hitCounter.getHits(600));
    }


}