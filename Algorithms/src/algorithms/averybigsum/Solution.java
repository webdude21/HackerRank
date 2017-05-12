package algorithms.averybigsum;

import java.util.Scanner;
import java.util.stream.LongStream;

class Solution {

	private static Scanner scanner;

	public static void main(String[] args) {
		scanner = new Scanner(System.in);
		System.out.println(LongStream.range(0, scanner.nextInt()).map(x -> scanner.nextLong()).sum());
	}
}