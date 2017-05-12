package algorithms.davisstaircase;

import java.util.Scanner;

class Solution {

	public static void main(String[] args) {

		Scanner in = new Scanner(System.in);
		int stairsCases = in.nextInt();
		for (int a0 = 0; a0 < stairsCases; a0++) {
			System.out.println(generateCombinations(in.nextInt(), 1));
		}

	}

	private static int generateCombinations(int stairs, int increment) {
		int ways = 0;

		if (stairs == 1) {
			return 1;
		}

		for (int i = increment; i <= stairs; i += increment) {
			ways += generateCombinations(stairs - increment, increment + 1);
			ways += 1;
		}

		return ways;
	}
}
