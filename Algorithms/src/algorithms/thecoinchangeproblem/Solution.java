package algorithms.thecoinchangeproblem;

import java.util.Scanner;

public class Solution {

    private static Scanner scanner;

    public static void main(String[] args) {
        scanner = new Scanner(System.in);
        int amount = scanner.nextInt();
        System.out.println(solve(amount));
    }

    public static long solve(int amount) {
        int[] coinTypes = new int[scanner.nextInt()];
        long[] table = new long[amount + 1];

        for (int i = 0; i < coinTypes.length; i++) {
            coinTypes[i] = scanner.nextInt();
        }

        table[0] = 1;

        for (int i = 0; i < coinTypes.length; i++) {
            for (int j = coinTypes[i]; j <= amount; j++) {
                table[j] += table[j - coinTypes[i]];
            }
        }

        return table[amount];
    }
}
