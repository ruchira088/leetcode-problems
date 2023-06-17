package com.ruchij.canva;

public class BulbSwitcher {
    public int bulbSwitch(int n) {
        return (int) Math.floor(Math.sqrt(n));
    }

//    public int bulbSwitch(int n) {
//        boolean[] bulbs = new boolean[n];
//        int on = 0;
//
//        for (int i = 1; i <= n; i++) {
//            toggle(bulbs, i);
//        }
//
//        for (boolean bulb : bulbs) {
//            if (bulb) {
//                on++;
//            }
//        }
//
//        return on;
//    }
//
//    private void toggle(boolean[] bulbs, int x) {
//        for (int i = x - 1; i < bulbs.length; i = i + x) {
//            bulbs[i] = !bulbs[i];
//        }
//    }
}
