package com.webdude.algorithms.sherlockandanagrams;

import java.util.Arrays;
import java.util.Scanner;

public class Solution {

    private static Scanner scanner;

	public static void main(String[] args) {
		scanner = new Scanner(System.in);
        int testCases = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < testCases; i++) {
            String input = scanner.nextLine();
            System.out.println(getAnagramCount(input));
        }
    }

    private static int getAnagramCount(String input) {
        int count = 0;
        for (int i = 0; i < input.length(); i++) {
            for (int k = i + 1; k < input.length(); k++) {
                int num = anagram(input.substring(i, k), input.substring(i + 1), input.substring(i, k).length());
                count = count + num;
            }
        }
        return count;
    }

    static int anagram(String s1, String s2, int len) {
        int count = 0;

        char[] c1 = s1.toCharArray();
        Arrays.sort(c1);
        String ss1 = new String(c1);
        int length = s2.length();

        for (int i = 0; i < length; i++) {
            if (i + len <= length) {
                String sub = s2.substring(i, i + len);
                char[] c2 = sub.toCharArray();
                Arrays.sort(c2);
                String ss2 = new String(c2);
                if (ss1.compareTo(ss2) == 0)
                    count++;
            }
        }
        return count;
    }
}