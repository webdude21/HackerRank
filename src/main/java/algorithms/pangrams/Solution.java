package algorithms.pangrams;

import java.util.Scanner;

class Solution {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String input = scanner.nextLine().toLowerCase();
		String output = "pangram";

		for (char alphabet = 'a'; alphabet <= 'z'; alphabet++) {
			if (!input.contains("" + alphabet)) {
				output = "not " + output;
				break;
			}
		}

		System.out.println(output);
	}
}
