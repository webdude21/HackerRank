package algorithms.combinations;

import java.util.Scanner;

class Solution {

	private static final Scanner scanner = new Scanner(System.in);

	private static final StringBuilder stringBuilder = new StringBuilder();

	private static int combinationCount = 0;

	public static void main(String[] args) {
		int n = scanner.nextInt();
		int[] elements = new int[n];
		generateCombinations(elements, 0);
		System.out.println(stringBuilder.toString());
		System.out.printf("Just printed %d combinations %n", combinationCount);
	}

	private static void generateCombinations(int[] elements, int index) {
		if (index >= elements.length) {
			combinationCount++;
			addToStringBuilder(elements);
			return;
		}

		for (int i = 0; i < elements.length; i++) {
			elements[index] = i + 1;
			generateCombinations(elements, index + 1);
		}
	}

	private static void addToStringBuilder(int[] elements) {
		for (int element : elements) {
			stringBuilder.append(element);
			stringBuilder.append(',');
		}

		stringBuilder.append(System.lineSeparator());
	}
}
