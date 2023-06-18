package com.ruchij.canva;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class ShippingPackagesTest {
    private final ShippingPackages shippingPackages = new ShippingPackages();

    @Test
    void returnsExpectedResult() {
        Assertions.assertEquals(15, shippingPackages.shipWithinDays(new int[]{1,2,3,4,5,6,7,8,9,10}, 5));
        Assertions.assertEquals(6, shippingPackages.shipWithinDays(new int[]{3,2,2,4,1,4}, 3));
        Assertions.assertEquals(3, shippingPackages.shipWithinDays(new int[]{1,2,3,1,1}, 4));
        Assertions.assertEquals(55, shippingPackages.shipWithinDays(new int[]{1,2,3,4,5,6,7,8,9,10}, 1));
    }

}