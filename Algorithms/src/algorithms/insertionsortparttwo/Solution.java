package algorithms.insertionsortparttwo;

import java.util.Scanner;
import java.util.stream.IntStream;

public class Solution {

    private static Scanner scanner;

    private static int[] array;

    public static void main(String[] args) {
        scanner = new Scanner(System.in);
        array = new int[scanner.nextInt()];

        for (int i = 0; i < array.length; i++) {
            array[i] = scanner.nextInt();
        }

        IntStream.range(1, array.length).forEach(Solution::sortFromStartingFrom);
    }

    private static void sortFromStartingFrom(int index) {
        int digitToSort = array[index];

        for (int i = index; i >= 0; i--) {
            if (i > 0 && digitToSort <= array[i - 1]) {
                array[i] = array[i - 1];
            } else {
                array[i] = digitToSort;
                printArray(array);
                break;
            }
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