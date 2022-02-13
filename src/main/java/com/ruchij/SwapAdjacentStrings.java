package com.ruchij;

import java.util.Map;

public class SwapAdjacentStrings {
    private Map<String, String> MAPPINGS = Map.of("XL", "LX", "RX", "XR");

    public boolean canTransform(String start, String end) {
        while (start.length() > 0) {
            String startSubString = start.substring(0, 1);
            String endSubString = end.substring(0, 1);

            if (startSubString.equals(endSubString)) {
                start = start.substring(1);
                end = end.substring(1);
            } else {
                if (start.length() >= 2) {
                    startSubString = start.substring(0, 2);
                    endSubString = end.substring(0, 2);

                    String replacement = MAPPINGS.get(startSubString);

                    if (replacement == null || !replacement.equals(endSubString)) {
                        return false;
                    } else {
                        start = replacement + start.substring(2);
                    }
                } else {
                    return false;
                }
            }
        }

        return true;
    }
}
