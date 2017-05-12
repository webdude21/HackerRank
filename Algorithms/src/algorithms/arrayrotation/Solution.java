package algorithms.arrayrotation;

import java.util.Scanner;

class Solution {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int[] array = new int[scanner.nextInt()];
		int rotations = readInput(scanner, array);
		printArrayWithRotation(array, rotations);
	}

	private static int readInput(Scanner scanner, int[] array) {
		int rotations = scanner.nextInt();

		scanner.nextLine();

		for (int i = 0; i < array.length; i++) {
			array[i] = scanner.nextInt();
		}
		return rotations;
	}

	private static void printArrayWithRotation(int[] array, int rotations) {
		StringBuilder sb = new StringBuilder();

		if (rotations > array.length) {
			rotations = array.length % rotations;
		}

		for (int i = 0; i < array.length; i++) {
			int adjustedIndex = i + rotations;

			if (adjustedIndex >= array.length) {
				adjustedIndex = adjustedIndex - array.length;
			}

			sb.append(array[adjustedIndex]);
			sb.append(" ");
		}

		System.out.println(sb.toString().trim());
	}
}