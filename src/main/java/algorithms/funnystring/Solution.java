package algorithms.funnystring;

import java.util.Scanner;

class Solution {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int testCases = scanner.nextInt();
		scanner.nextLine();

		for (int i = 0; i < testCases; i++) {
			System.out.println(isFunny(scanner.nextLine()) ? "Funny" : "Not Funny");
		}
	}

	private static boolean isFunny(String input) {
		String reversed = new StringBuilder(input).reverse().toString();

		for (int i = 1; i < reversed.length(); i++) {
			if (formula(input, i) != formula(reversed, i)) {
				return false;
			}
		}

		return true;
	}

	private static int formula(String input, int indexStart) {
		return Math.abs(input.charAt(indexStart - 1) - input.charAt(indexStart));
	}
}
