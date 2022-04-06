package com.ruchij;

import java.util.ArrayList;
import java.util.Comparator;

public class MaximumUnitsOnTruck {
    record Product(int boxCount, int unitsPerBox) {}

    public int maximumUnits(int[][] boxTypes, int truckSize) {
        ArrayList<Product> products = new ArrayList<>();
        int count = 0;

        for (int[] box : boxTypes) {
            products.add(new Product(box[0], box[1]));
        }

        products.sort(Comparator.comparingInt(Product::unitsPerBox).reversed());

        for (Product product : products) {
            if (product.boxCount <= truckSize) {
                count += product.boxCount * product.unitsPerBox;
                truckSize -= product.boxCount;
            } else if (truckSize > 0) {
                count += truckSize * product.unitsPerBox;
                truckSize = 0;
            } else {
                return count;
            }
        }

        return count;

    }
}
