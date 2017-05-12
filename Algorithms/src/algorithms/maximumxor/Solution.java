package algorithms.maximumxor;

import java.util.Scanner;

class Solution {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int L = scanner.nextInt();
		int R = scanner.nextInt();
		int maxXor = Integer.MIN_VALUE;

		for (int i = L; i <= R; i++) {
			for (int j = L; j <= R; j++) {
				int currentValue = i ^ j;
				if (currentValue > maxXor) {
					maxXor = currentValue;
				}
			}
		}

		System.out.println(maxXor);
	}

}
