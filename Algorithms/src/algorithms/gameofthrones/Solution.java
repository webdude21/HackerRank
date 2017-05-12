package algorithms.gameofthrones;

import java.util.Scanner;

class Solution {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		boolean[] charOddCount = new boolean[26];
		char[] input = scanner.nextLine().toCharArray();

		for (char chr : input) {
			charOddCount[chr - 'a'] = !charOddCount[chr - 'a'];
		}

		int oddCountChars = 0;

		for (boolean isOdd : charOddCount) {
			if (isOdd) {
				oddCountChars++;
			}
		}

		System.out.println(oddCountChars < 2 ? "YES" : "NO");
	}
}
