package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CurrencyConvertorTest {

    @Test
    void testGetExchangeRate() {
        double exchangeRate = CurrencyConvertor.getExchangeRate("USD", "EUR");
        assertEquals(0.85, exchangeRate, 0.001);
    }

    @Test
    void testConvertCurrency() {
        double convertedAmount = CurrencyConvertor.convertCurrency(100, "USD", "EUR");
        assertEquals(85, convertedAmount, 0.001);
    }

    @Test
    void testValidateCurrencyCode() {
        assertTrue(CurrencyConvertor.validateCurrencyCode("USD"));
        assertFalse(CurrencyConvertor.validateCurrencyCode("XYZ"));
    }

    @Test
    void testAddCurrency() {
        CurrencyConvertor.addCurrency("GBP", 0.75);
        assertTrue(CurrencyConvertor.validateCurrencyCode("GBP"));

    }

    @Test
    void testIsCurrencyStronger() {
        assertTrue(CurrencyConvertor.isCurrencyStronger("USD", "EUR"));

        assertFalse(CurrencyConvertor.isCurrencyStronger("EUR", "USD"));

        assertFalse(CurrencyConvertor.isCurrencyStronger("USD", "USD"));

    }
}