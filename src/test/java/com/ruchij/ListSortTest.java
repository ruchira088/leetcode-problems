package com.ruchij;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

class ListSortTest {
    @Test
    void testOne() {
        ArrayList arrayList = new ArrayList(List.of(List.of(0, 1, 2, 3), List.of(0, 2)));
        arrayList.sort(ListSort.listComparator);
        System.out.println(arrayList);
    }

}