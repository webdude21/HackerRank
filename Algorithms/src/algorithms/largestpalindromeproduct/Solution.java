package algorithms.largestpalindromeproduct;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;
import java.util.TreeSet;

class Solution {

	private static final TreeSet<Integer> calculatedPalindromeProducts = calculatePalindromes();

	private static TreeSet<Integer> calculatePalindromes() {
		int product;
		TreeSet<Integer> calculatedPalindromeProducts = new TreeSet<>(Comparator.reverseOrder());

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

	private static boolean isPalindrome(int product) {
		StringBuilder temp = new StringBuilder(Integer.toString(product)).reverse();
		return temp.toString().equals(Integer.toString(product));
	}

	public static void main(String[] args) {
		ArrayList<Integer> input = readInput();
		input.stream().map(calculatedPalindromeProducts::ceiling).forEach(System.out::println);
	}

	private static ArrayList<Integer> readInput() {
		Scanner scanner = new Scanner(System.in);
		int linesOfInput = scanner.nextInt();
		ArrayList<Integer> input = new ArrayList<>();

		for (int i = 0; i < linesOfInput; i++) {
			scanner.nextLine();
			input.add(scanner.nextInt());
		}

		return input;
	}
}
