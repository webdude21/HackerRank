package algorithms.countingsortone;

import java.util.Scanner;

public class Solution {

    private static Scanner scanner;

    public static void main(String[] args) {
        scanner = new Scanner(System.in);
        
        int digitCount = scanner.nextInt();
        int[] countResult = new int[100];
        
        for (int i = 0; i < digitCount; i++) {
            countResult[scanner.nextInt()]++;
        };
        
        printArray(countResult);
    }
    
    private static void printArray(int[] array) {
        StringBuilder sb = new StringBuilder();

        for (int anArray : array) {
            sb.append(anArray);
            sb.append(" ");
        }

        System.out.println(sb.toString().trim());
    }
}
