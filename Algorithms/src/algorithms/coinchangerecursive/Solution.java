package algorithms.coinchangerecursive;

import java.util.Scanner;

class Solution {

	private static long solutionCount = 0;

	private static int[] coins;

	private static void makeChange(int amount, int startIndex, int currentAmount) {
		if (currentAmount == amount) {
			solutionCount++;
			return;
		}

		for (int i = startIndex; i < coins.length; i++) {
			currentAmount += coins[i];
			makeChange(amount, startIndex + 1, currentAmount);
		}
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int m = in.nextInt();
		coins = new int[m];
		for (int coins_i = 0; coins_i < m; coins_i++) {
			coins[coins_i] = in.nextInt();
		}

		makeChange(n, 0, 0);
		System.out.println(solutionCount);
	}
}
