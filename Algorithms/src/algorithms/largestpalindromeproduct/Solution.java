package algorithms.largestpalindromeproduct;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.TreeSet;

public class Solution {

    public static TreeSet<Integer> calculatedPalindromeProducts = calculatePalindromes();
    private static Scanner scanner;

    public static TreeSet<Integer> calculatePalindromes() {
        int product;
        TreeSet<Integer> calculatedPalindromeProducts = new TreeSet<>((o1, o2) -> o2.compareTo(o1));

        for (int i = 999; i > 100; i--) {
            for (int j = i; j > 100; j--) {
                product = i * j;
                if (isPalindrome(product)) {
                    calculatedPalindromeProducts.add(product);
                }
            }
        }

        return calculatedPalindromeProducts;
    }

    public static boolean isPalindrome(int product) {
        StringBuilder temp = new StringBuilder(Integer.toString(product)).reverse();
        return temp.toString().equals(Integer.toString(product));
    }

    public static void main(String[] args) {
        ArrayList<Integer> input = readInput();
        input.stream().map(n -> calculatedPalindromeProducts.ceiling(n)).forEach(System.out::println);
    }

    public static ArrayList<Integer> readInput() {
        scanner = new Scanner(System.in);
        int linesOfInput = scanner.nextInt();
        ArrayList<Integer> input = new ArrayList<>();

        for (int i = 0; i < linesOfInput; i++) {
            scanner.nextLine();
            input.add(scanner.nextInt());
        }

        return input;
    }
}
