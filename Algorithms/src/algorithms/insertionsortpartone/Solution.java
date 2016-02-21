package algorithms.insertionsortpartone;

import java.util.Scanner;

public class Solution {

    private static Scanner scanner;

    public static void main(String[] args) {
        scanner = new Scanner(System.in);
        int[] array = new int[scanner.nextInt()];

        for (int i = 0; i < array.length; i++) {
            array[i] = scanner.nextInt();
        }

        int digitToSort = array[array.length - 1];

        for (int i = array.length - 1; i >= 0; i--) {
            if (i > 0 && digitToSort <= array[i - 1]) {
                array[i] = array[i - 1];
            } else {
                array[i] = digitToSort;
                printArray(array);
                break;
            }

            printArray(array);
        }

    }

    private static void printArray(int[] array) {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < array.length; i++) {
            sb.append(array[i]);
            sb.append(" ");
        }

        System.out.println(sb.toString().trim());
    }
}
