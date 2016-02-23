package algorithms.finddigits;

import java.util.Scanner;

public class Solution {

    private static Scanner scanner;

    public static void main(String[] args) {
        scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();

        for (int i = 0; i < testCases; i++) {
            System.out.println(testNumber(scanner.nextInt()));
        }
    }

    public static int testNumber(int input) {
        char[] digits = String.valueOf(input).toCharArray();
        int result = 0;

        for (char c : digits) {
            int digit = c - '0';
            if (digit > 0 && input % digit == 0) {
                result++;
            }
        }
        return result;
    }
}
