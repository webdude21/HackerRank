package algorithms.gameofthrones;

import java.util.Scanner;

public class Solution {

    private static Scanner scanner;

    public static void main(String[] args) {
        scanner = new Scanner(System.in);
        boolean[] charOddCount = new boolean[26];
        char[] input = scanner.nextLine().toCharArray();

        for (int i = 0; i < input.length; i++) {
            charOddCount[input[i] - 'a'] = !charOddCount[input[i] - 'a'];
        }

        int oddCountChars = 0;
        
        for (boolean isOdd : charOddCount) {
            if (isOdd){
                oddCountChars++;
            }
        }

        System.out.println(oddCountChars < 2 ? "YES" : "NO");
    }
}
