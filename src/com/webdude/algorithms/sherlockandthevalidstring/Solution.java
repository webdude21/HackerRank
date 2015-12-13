package com.webdude.algorithms.sherlockandthevalidstring;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Solution {

    public static void main(String[] args) {
        PrintResult(checkIfValid(convertToListOfOccurrences(readInputFromStdIn())));
    }

    private static String readInputFromStdIn() {
        return new Scanner(System.in).nextLine();
    }

    private static boolean checkIfCanBeModifiedToValid(List<Integer> listOfOccurrences) {
        for (int i = 0; i < listOfOccurrences.size(); i++) {
            int itemToTryWithout = listOfOccurrences.remove(i);

            if (checkIfValid(listOfOccurrences)) {
                return true;
            }

            listOfOccurrences.add(i, itemToTryWithout);
        }
        return false;
    }

    private static void PrintResult(Boolean validString) {
        System.out.println(validString ? "YES" : "NO");
    }

    public static boolean checkIfValid(List<Integer> listOfOccurrences) {
        int lastOccurrence = 0;

        for (int occurrence : listOfOccurrences) {
            if (lastOccurrence == 0) {
                lastOccurrence = occurrence;
            }

            if (occurrence != lastOccurrence) {
                return false;
            }
        }

        return checkIfCanBeModifiedToValid(listOfOccurrences);
    }

    private static List<Integer> convertToListOfOccurrences(String input) {
        Map<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < input.length(); i++) {
            char currentChar = input.charAt(i);
            if (!map.containsKey(currentChar)) {
                map.put(currentChar, 1);
            } else {
                map.put(currentChar, map.get(currentChar) + 1);
            }
        }

        return map.values().stream().collect(Collectors.toList());
    }
}