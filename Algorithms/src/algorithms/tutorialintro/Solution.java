package algorithms.tutorialintro;

import java.util.Scanner;

class Solution {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int valueToLookFor = scanner.nextInt();
		int arraySize = scanner.nextInt();

		for (int i = 0; i < arraySize; i++) {
			int currentValue = scanner.nextInt();
			if (currentValue == valueToLookFor) {
				System.out.println(i);
				return;
			}
		}
	}
}
