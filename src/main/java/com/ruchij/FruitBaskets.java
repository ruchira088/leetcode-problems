package com.ruchij;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

public class FruitBaskets {

    public int totalFruit(int[] fruits) {
        int max = 0;
        HashSet<Integer> picked = new HashSet<>();
        Stack<Integer> pickOrder = new Stack<>();

        for (int fruit : fruits) {
            if (picked.size() < 2 || picked.contains(fruit)) {
                picked.add(fruit);
                pickOrder.push(fruit);
            } else {
                int size = pickOrder.size();

                if (size > max) {
                    max = size;
                }

                int lastFruit = pickOrder.peek();
                Stack<Integer> nextPickOrder = new Stack<>();

                while (pickOrder.peek() == lastFruit) {
                    nextPickOrder.add(pickOrder.pop());
                }

                nextPickOrder.push(fruit);
                pickOrder = nextPickOrder;
                picked = new HashSet<>(Set.of(lastFruit, fruit));
            }
        }

        return Math.max(max, pickOrder.size());
    }

}
