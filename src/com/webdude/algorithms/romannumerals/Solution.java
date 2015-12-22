package com.webdude.algorithms.romannumerals;

import java.util.*;

public class Solution {

    private static final Map<Character, Integer> romanNumeral = getRomanNumerals();
    private static final NavigableMap<Integer, String> optimalNumberUsage = getOptimumConversionNumbers();
	private static Scanner scanner;

    public static void main(String[] args) {
		scanner = new Scanner(System.in);
        int linesOfInput = scanner.nextInt();
        scanner.nextLine();

        for (int i = 0; i < linesOfInput; i++) {
            String output = convertToRoman(convertFromRoman(scanner.nextLine()));
            System.out.println(output);
        }
    }

    public static String convertToRoman(int number) {
        int startNumber = optimalNumberUsage.floorKey(number);
        if (number == startNumber) {
            return optimalNumberUsage.get(number);
        }
        return optimalNumberUsage.get(startNumber) + convertToRoman(number - startNumber);
    }

    public static int convertFromRoman(String romanNumber) {
        int result = 0;
        char[] charsInRomanNumber = romanNumber.toCharArray();

        for (char romanDigit : charsInRomanNumber) {
            result += romanNumeral.get(romanDigit);
        }

        return result;
    }

    public static Map<Character, Integer> getRomanNumerals() {
        Map<Character, Integer> romanNumerals = new HashMap<>();

        romanNumerals.put('I', 1);
        romanNumerals.put('V', 5);
        romanNumerals.put('X', 10);
        romanNumerals.put('L', 50);
        romanNumerals.put('C', 100);
        romanNumerals.put('D', 500);
        romanNumerals.put('M', 1000);

        return romanNumerals;
    }

    public static NavigableMap<Integer, String> getOptimumConversionNumbers() {
        NavigableMap<Integer, String> optimalNumber = new TreeMap<>();

        optimalNumber.put(1000, "M");
        optimalNumber.put(900, "CM");
        optimalNumber.put(500, "D");
        optimalNumber.put(400, "CD");
        optimalNumber.put(100, "C");
        optimalNumber.put(90, "XC");
        optimalNumber.put(50, "L");
        optimalNumber.put(40, "XL");
        optimalNumber.put(10, "X");
        optimalNumber.put(9, "IX");
        optimalNumber.put(5, "V");
        optimalNumber.put(4, "IV");
        optimalNumber.put(1, "I");

        return optimalNumber;
    }
}
