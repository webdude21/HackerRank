package com.webdude.algorithms.sherlockandthevalidstring;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        String input = readInputFromFile();
        Map<Character, Integer> mappedString = readToMap(input);
        Boolean validString = checkIfValid(readToMap(input));

        if (!validString) {
            validString = checkIfCanBeModifiedToValid(mappedString);
        }

        PrintResult(validString);
    }

    private static String readInputFromStdIn() {
        Scanner in = new Scanner(System.in);
        return in.nextLine();
    }

    private static String readInputFromFile() {
        File inputFile = new File("./src/com/webdude/algorithms/sherlockandthevalidstring/input12.txt");
        String input = "";

        try {
            Scanner in = new Scanner(inputFile);
            input = in.nextLine();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        return input;
    }

    private static boolean checkIfCanBeModifiedToValid(Map<Character, Integer> input) {
        int lastOccurrence = 0;
        int movesNeededToFix = 0;

        for (int occurrence : input.values()) {
            if (lastOccurrence == 0) {
                lastOccurrence = occurrence;
            }

            if (occurrence != lastOccurrence) {
                movesNeededToFix++;
            }

            if (movesNeededToFix > 1) {
                return false;
            }
        }

        return true;
    }

    private static void PrintResult(Boolean validString) {
        System.out.println(validString ? "YES" : "NO");
    }

    public static boolean checkIfValid(Map<Character, Integer> map) {
        int distinctChars = map.size();
        int lastOccurrence = 0;

        for (int occurrence : map.values()) {
            if (lastOccurrence == 0) {
                lastOccurrence = occurrence;
            }

            if (occurrence != lastOccurrence) {
                return false;
            }
        }

        return distinctChars == lastOccurrence;
    }

    private static Map<Character, Integer> readToMap(String input) {
        Map<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < input.length(); i++) {
            char currentChar = input.charAt(i);
            if (!map.containsKey(currentChar)) {
                map.put(currentChar, 1);
            } else {
                map.put(currentChar, map.get(currentChar) + 1);
            }
        }

        return map;
    }
}