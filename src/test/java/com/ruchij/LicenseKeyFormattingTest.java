package com.ruchij;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LicenseKeyFormattingTest {

    @Test
    void returnExpectedResult() {
        LicenseKeyFormatting licenseKeyFormatting = new LicenseKeyFormatting();
        assertEquals("5F3Z-2E9W", licenseKeyFormatting.licenseKeyFormatting("5F3Z-2e-9-w", 4));
        assertEquals("2-5G-3J", licenseKeyFormatting.licenseKeyFormatting("2-5g-3-J", 2));
    }

}