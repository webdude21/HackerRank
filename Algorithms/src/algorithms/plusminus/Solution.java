package algorithms.plusminus;

import java.util.Scanner;

public class Solution {

    private static Scanner scanner;

    public static void main(String[] args) {
        scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        double[] results = new double[] { 0, 0, 0 };

        for (int i = 0; i < n; i++) {
            double currentNumber = scanner.nextDouble();

            if (currentNumber > 0) {
                results[0]++;
            } else if (currentNumber < 0) {
                results[1]++;
            } else {
                results[2]++;
            }
        }

        for (double result1 : results) {
            double result = 0;
            if (result1 > 0) {
                result = result1 / n;
            }
            System.out.println(result);
        }
    }
}