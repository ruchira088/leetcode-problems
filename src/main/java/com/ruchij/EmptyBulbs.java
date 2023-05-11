package com.ruchij;

public class EmptyBulbs {
    public int kEmptySlots(int[] bulbs, int k) {
        int[] lights = new int[bulbs.length];

        for (int i = 0; i < bulbs.length; i++) {
            int bulb = bulbs[i] - 1;
            lights[bulb] = 1;

            if (isComplete(lights, k, bulb)) {
                return i + 1;
            }
        }

        return -1;
    }

    boolean isComplete(int[] lights, int k, int bulb) {
        int right = Math.min(bulb + 1 + k, lights.length - 1);

        for (int i = bulb + 1; i <= right; i++) {
            if (i != bulb + 1 + k && lights[i] == 1) {
                break;
            } else if (i == bulb + 1 + k && lights[i] == 0) {
                break;
            } else if (i == bulb + 1 + k && lights[i] == 1) {
                return true;
            }
        }

        int left = Math.max(0, bulb - 1 - k);

        for (int i = bulb - 1; i >= left; i--) {
            if (i != bulb - 1 - k && lights[i] == 1) {
                break;
            } else if (i == bulb - 1 - k && lights[i] == 0) {
                break;
            } else if (i == bulb - 1 - k && lights[i] == 1) {
                return true;
            }
        }

        return false;
    }
}
