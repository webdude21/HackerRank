package algorithms.permutations;

import java.util.Scanner;

public class Solution {

	private static Scanner scanner = new Scanner(System.in);

	private static int permutationCount = 0;

	private static StringBuilder stringBuilder = new StringBuilder();

	public static void main(String[] args) {
		int n = scanner.nextInt();
		int[] elements = new int[n];
		generatePermutations(elements, new boolean[n], 0);
		System.out.println(stringBuilder.toString());
		System.out.printf("Just printed %d permutations %n", permutationCount);
	}

	private static void generatePermutations(int[] elements, boolean[] used, int index) {
		if (index >= elements.length) {
			permutationCount++;
			addToStringBuilder(elements);
			return;
		}

		for (int i = 0; i < elements.length; i++) {
			if (!used[i]) {
				elements[index] = i + 1;
				used[i] = true;
				generatePermutations(elements, used, index + 1);
				used[i] = false;
			}
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
