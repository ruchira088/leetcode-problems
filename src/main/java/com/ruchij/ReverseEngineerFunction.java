package com.ruchij;

import java.util.ArrayList;
import java.util.List;

public class ReverseEngineerFunction {
    static class CustomFunction {
        public int f(int x, int y) { return x + y; }
    }

    public List<List<Integer>> findSolution(CustomFunction customfunction, int z) {
        List<List<Integer>> result = new ArrayList<>();

        for (int i = 1; ; i++) {
            int start = result.size();
            for (int j = 0; j <= 1000; j++) {
                int value = customfunction.f(i, j);
                  if (value == z) {
                      result.add(List.of(i, j));
                  } else if (value > z) {
                      break;
                  }
            }

            if (result.size() == start) {
                break;
            }
        }

        return result;
    }
}
