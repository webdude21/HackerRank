package algorithms.stockmaximize;

import java.util.Scanner;

public class Solution {

	private static Scanner scanner;

	public static void main(String[] args) {
		scanner = new Scanner(System.in);
		int testCases = scanner.nextInt();

		for (int i = 0; i < testCases; i++) {
			System.out.println(solveTestCase(scanner.nextInt()));
		}
	}

	private static long solveTestCase(int nextInt) {
		int maxFuturePrice = 0;
		long profit = 0;
		int[] solution = new int[nextInt];

		for (int i = 0; i < nextInt; i++) {
			solution[i] = scanner.nextInt();
		}

		for (int i = solution.length - 1; i >= 0; i--) {
			maxFuturePrice = Math.max(maxFuturePrice, solution[i]);
			profit += maxFuturePrice - solution[i];
		}

		return profit;
	}
}
