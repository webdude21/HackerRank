package algorithms.lonelyinteger;

import java.util.Scanner;

class Solution {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int testCases = scanner.nextInt();
		Integer result = 0;

		for (int i = 0; i < testCases; i++) {
			result ^= scanner.nextInt();
		}

		System.out.println(result);
	}
}
