package algorithms.staircase;

import java.util.Scanner;

class Solution {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int input = scanner.nextInt();
		StringBuilder sb = new StringBuilder();

		sb.appendCodePoint(1);

		for (int i = 1; i <= input; i++) {
			for (int j = 1; j <= input; j++) {
				if (j <= input - i) {
					sb.append(' ');
				} else {
					sb.append('#');
				}
			}

			if (i < input) {
				sb.append('\n');
			}
		}

		System.out.print(sb.toString());
	}
}
