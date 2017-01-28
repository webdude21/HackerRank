package algorithms.lonelyinteger;

import java.util.Scanner;

public class Solution {

	private static Scanner scanner;

	public static void main(String[] args) {
		scanner = new Scanner(System.in);
		int testCases = scanner.nextInt();
		Integer result = 0;

		for (int i = 0; i < testCases; i++) {
			result ^= scanner.nextInt();
		}

		System.out.println(result);
	}
}