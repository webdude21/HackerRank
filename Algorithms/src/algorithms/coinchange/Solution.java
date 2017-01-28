package algorithms.coinchange;

import java.util.Scanner;

public class Solution {

	private static long makeChange(int[] coins, int amount) {
		long[] solutions = new long[amount + 1];

		solutions[0] = 1;

		for (int coin : coins) {
			for (int j = coin; j <= amount; j++) {
				solutions[j] += solutions[j - coin];
			}
		}

		return solutions[amount];
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int m = in.nextInt();
		int coins[] = new int[m];
		for (int coins_i = 0; coins_i < m; coins_i++) {
			coins[coins_i] = in.nextInt();
		}
		System.out.println(makeChange(coins, n));
	}
}
