package com.ruchij;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class AmazonFreshPromo {
    public static int foo(List<String> codeList, List<String> shoppingCart) {
        // Write your code here
        List<List<String>> codes = codeList.stream().map(code -> Arrays.stream(code.split(" ")).collect(Collectors.toList())).collect(Collectors.toList());

        return isApplicable(List.of(), codes, shoppingCart, 0);
    }

    private static int isApplicable(List<String> codes, List<List<String>> rest, List<String> shoppingCart, int index) {
        if (codes.isEmpty()) {
            if (rest.isEmpty()) {
                return 1;
            } else {
                int size = shoppingCart.size();
                int restSize = rest.stream().mapToInt(List::size).sum();
                List<String> nextCodes = rest.get(0);
                List<List<String>> remaining = rest.subList(1, rest.size());

                for (int i = index; i < size - restSize; i++) {
                    int result = isApplicable(nextCodes, remaining, shoppingCart, i);

                    if (result == 1) {
                        return 1;
                    }
                }

                return 0;
            }
        } else if (shoppingCart.size() == index) {
            return 0;
        } else {
            String codeItem = codes.get(0);
            String shoppingCartItem = shoppingCart.get(index);

            if (codeItem.equals(shoppingCartItem) || codeItem.equals("anything")) {
                return isApplicable(codes.subList(1, codes.size()), rest, shoppingCart, index + 1);
            } else {
                return 0;
            }

        }
    }

}
