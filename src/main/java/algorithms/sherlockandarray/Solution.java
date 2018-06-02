package algorithms.sherlockandarray;

import java.util.Scanner;

class Solution {

	private static Scanner scanner;

	public static void main(String[] args) {
		scanner = new Scanner(System.in);
		int testCases = scanner.nextInt();

		for (int i = 0; i < testCases; i++) {
			System.out.println(passesTest(scanner.nextInt()) ? "YES" : "NO");
		}
	}

	private static boolean passesTest(int arrayLength) {
		int[] testArray = new int[arrayLength];

		int rightNum = 0;
		int leftNum = 0;
		int currentNum;

		for (int i = 0; i < testArray.length; i++) {
			currentNum = scanner.nextInt();
			rightNum += currentNum;
			testArray[i] = currentNum;
		}

		for (int i = 0; i < testArray.length; i++) {
			if (i > 0) {
				leftNum += testArray[i - 1];
			}

			rightNum -= testArray[i];

			if (rightNum == leftNum) {
				return true;
			}
		}

		return false;
	}
}
