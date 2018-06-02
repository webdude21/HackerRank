package algorithms.runningtimeofalgorithms;

import java.util.Scanner;
import java.util.stream.IntStream;

class Solution {

	private static int[] array;

	private static int runningTime = 0;

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		array = new int[scanner.nextInt()];

		for (int i = 0; i < array.length; i++) {
			array[i] = scanner.nextInt();
		}

		IntStream.range(1, array.length).forEach(Solution::sortFromStartingFrom);
		System.out.println(runningTime);
	}

	private static void sortFromStartingFrom(int index) {
		int digitToSort = array[index];

		for (int i = index; i >= 0; i--) {
			if (i > 0 && digitToSort < array[i - 1]) {
				array[i] = array[i - 1];
				runningTime += 1;
			} else {
				array[i] = digitToSort;
				break;
			}
		}
	}
}
