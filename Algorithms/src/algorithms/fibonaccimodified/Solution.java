package algorithms.fibonaccimodified;

import java.math.BigInteger;
import java.util.Scanner;

public class Solution {

    private static Scanner scanner;

    public static void main(String[] args) {
        scanner = new Scanner(System.in);
        BigInteger a = scanner.nextBigInteger();
        BigInteger b = scanner.nextBigInteger();
        int n = scanner.nextInt() - 2;
        BigInteger result = null;

        for (int i = 0; i < n; i++) {
            result = a.add(b.multiply(b));
            a = b;
            b = result;
        }

        System.out.println(result);
    }
}
