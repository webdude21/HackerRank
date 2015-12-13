package com.webdude.algorithms.sherlockandthevalidstring;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
import java.util.stream.Collectors;

public class Solution {

    public static void main(String[] args) {
        String input = readInputFromStdIn();
        ArrayList<Integer> mappedString = convertToListOfOccurrences(input);
        Boolean validString = checkIfValid(mappedString);

        if (!validString) {
            validString = checkIfCanBeModifiedToValid(mappedString);
        }

        PrintResult(validString);
    }

    private static String readInputFromStdIn() {
        return new Scanner(System.in).nextLine();
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

    private static boolean checkIfCanBeModifiedToValid(ArrayList<Integer> listOfOccurrences) {
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

    public static boolean checkIfValid(ArrayList<Integer> listOfOccurrences) {
        int lastOccurrence = 0;

        for (int occurrence : listOfOccurrences) {
            if (lastOccurrence == 0) {
                lastOccurrence = occurrence;
            }

            if (occurrence != lastOccurrence) {
                return false;
            }
        }

        return true;
    }

    private static ArrayList<Integer> convertToListOfOccurrences(String input) {
        Map<Character, Integer> map = new HashMap<>();
        ArrayList<Integer> occurrences = new ArrayList<>();

        for (int i = 0; i < input.length(); i++) {
            char currentChar = input.charAt(i);
            if (!map.containsKey(currentChar)) {
                map.put(currentChar, 1);
            } else {
                map.put(currentChar, map.get(currentChar) + 1);
            }
        }

        occurrences.addAll(map.values().stream().collect(Collectors.toList()));
        Collections.sort(occurrences);
        return occurrences;
    }
}