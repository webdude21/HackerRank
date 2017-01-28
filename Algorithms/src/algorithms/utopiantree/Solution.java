package algorithms.utopiantree;

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

	private static int solveTestCase(int cycles) {
		int treeHeight = 1;

		for (int i = 0; i < cycles; i++) {
			if (i % 2 == 0) {
				treeHeight *= 2;
			} else {
				treeHeight += 1;
			}
		}

		return treeHeight;
	}
}