package algorithms.sansaandxor;

import java.util.Scanner;

public class Solution {

	private static Scanner scanner;

	public static void main(String[] args) {
		scanner = new Scanner(System.in);
		long testCases = scanner.nextLong();

		for (long i = 0; i < testCases; i++) {
			System.out.println(solveTestCase());
		}
	}

	public static long solveTestCase() {
		long result = 0;
		long arrayLength = scanner.nextLong();

		for (long i = 0; i < arrayLength; i++) {
			long currentValue = scanner.nextLong();
			if (i % 2 == 0) {
				result ^= currentValue;
			}
		}

		return arrayLength % 2 == 0 ? 0 : result;
	}

}
