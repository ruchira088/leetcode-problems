package com.ruchij;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class LRUCacheTest {

    @Test
    void testOne() {
        LRUCacheEasy lruCache = new LRUCacheEasy(2);
        lruCache.put(1, 1);
        lruCache.put(2, 2);
        lruCache.get(1);
        lruCache.put(3, 3);
        Assertions.assertEquals(-1, lruCache.get(2));
    }

}