package com.webdude.algorithms.pangrams;

import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        String input = new Scanner(System.in).nextLine().toLowerCase();
        String output = "pangram";

        for (char alphabet = 'a'; alphabet <= 'z'; alphabet++) {
            if (!input.contains("" + alphabet)) {
                output = "not pangram";
                break;
            }
        }

        System.out.println(output);
    }
}
