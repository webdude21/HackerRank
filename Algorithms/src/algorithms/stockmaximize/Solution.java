package algorithms.stockmaximize;

import java.util.Scanner;

public class Solution {

    private static Scanner scanner;

    public static void main(String[] args) {
        scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();

        for (int i = 0; i < testCases; i++) {
           System.out.println(solve(scanner.nextInt()));
        }
    }

    private static char[] solve(int nextInt) {
        int[] sharePrice = new int[nextInt];
        
        for (int i = 0; i < nextInt; i++) {
           sharePrice[i] = scanner.nextInt();
        }
        return null;
    }

}
