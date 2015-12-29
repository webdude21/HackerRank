package algorithms.gameofthrones;

import java.util.Scanner;

public class Solution {

    private static Scanner scanner;

    public static void main(String[] args) {
        scanner = new Scanner(System.in);
        int[] charactersOccurance = new int[30];
        char[] input = scanner.nextLine().toCharArray();

        for (int i = 0; i < input.length; i++) {
            charactersOccurance[input[i] - 'a']++;
        }

        int odd = 0;
        for (int i = 0; i < charactersOccurance.length; i++) {
            if (charactersOccurance[i] % 2 != 0) {
                odd++;
            }
        }

        System.out.println(odd < 2 ? "YES" : "NO");
    }
}
