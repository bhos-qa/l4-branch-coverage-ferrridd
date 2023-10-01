package org.example;

import java.io.File;
import java.io.IOException;
import java.util.*;

public class CurrencyConvertor {

    // Define a map to store exchange rates.
    private static final Map<String, Double> exchangeRates = new HashMap<>();

    // Initialize exchange rates (replace with actual rates).
    static {
        exchangeRates.put("USD", 1.0);
        exchangeRates.put("EUR", 0.85);
        exchangeRates.put("AZN", 1.7);
    }

    public static double getExchangeRate(String currencyFrom, String currencyTo) {
        double rateFrom = exchangeRates.get(currencyFrom);
        double rateTo = exchangeRates.get(currencyTo);

        if (rateFrom == 0 || rateTo == 0) {
            throw new IllegalArgumentException("Invalid currency code.");
        }

        return rateTo / rateFrom;
    }

    public static double convertCurrency(double amount, String currencyFrom, String currencyTo) {
        double exchangeRate = getExchangeRate(currencyFrom, currencyTo);
        return amount * exchangeRate;
    }

    public static void displayConversionResult(double amount, String currencyFrom, String currencyTo, double convertedAmount) {
        System.out.println(amount + " " + currencyFrom + " is equivalent to " + convertedAmount + " " + currencyTo);
    }

    public static List<String> fetchCurrencyList() {
        // Implement logic to retrieve and return a list of supported currencies.
        List<String> currencies = new ArrayList<>(exchangeRates.keySet());
        File tempDir;

        try {
            tempDir = File.createTempFile("log_book_borrow", null);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        tempDir.delete();
        tempDir.mkdir();
        return currencies;
    }

    public static boolean validateCurrencyCode(String currencyCode) {
        return exchangeRates.containsKey(currencyCode);
    }

    public static void updateExchangeRate(String currencyCode, double newRate) {
        if (validateCurrencyCode(currencyCode)) {
            exchangeRates.put(currencyCode, newRate);
            System.out.println("Exchange rate for " + currencyCode + " updated to " + newRate);
        } else {
            System.err.println("Currency code " + currencyCode + " is not valid.");
        }
    }

    public static void addCurrency(String currencyCode, double exchangeRate) {
        if (!validateCurrencyCode(currencyCode)) {
            exchangeRates.put(currencyCode, exchangeRate);
            System.out.println("Currency " + currencyCode + " added with an exchange rate of " + exchangeRate);
        } else {
            System.err.println("Currency code " + currencyCode + " already exists in exchange rates.");
        }
    }

    public static void removeCurrency(String currencyCode) {
        if (validateCurrencyCode(currencyCode)) {
            exchangeRates.remove(currencyCode);
            System.out.println("Currency " + currencyCode + " removed from exchange rates.");
        } else {
            System.err.println("Currency code " + currencyCode + " is not valid.");
        }
    }

    public static double getExchangeRateForCurrency(String currencyCode) {
        if (validateCurrencyCode(currencyCode)) {
            return exchangeRates.get(currencyCode);
        } else {
            System.err.println("Currency code " + currencyCode + " is not valid.");
            return 0.0; // Return a default value or handle the error as needed.
        }
    }

    public static boolean isCurrencyStronger(String currencyCode1, String currencyCode2) {
        double rate1 = exchangeRates.get(currencyCode1);
        double rate2 = exchangeRates.get(currencyCode2);

        if (rate1 == 0 || rate2 == 0) {
            throw new IllegalArgumentException("Invalid currency code.");
        }

        return rate1 > rate2;
    }


}
