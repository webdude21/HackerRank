package algorithms.pangrams;

import java.util.Scanner;

public class Solution {

    private static Scanner scanner;

    public static void main(String[] args) {
        scanner = new Scanner(System.in);
        String input = scanner.nextLine().toLowerCase();
        String output = "pangram";

        for (char alphabet = 'a'; alphabet <= 'z'; alphabet++) {
            if (!input.contains("" + alphabet)) {
                output = "not " + output;
                break;
            }
        }

        System.out.println(output);
    }
}
