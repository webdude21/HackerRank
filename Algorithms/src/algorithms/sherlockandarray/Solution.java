package algorithms.sherlockandarray;

import java.util.Scanner;

public class Solution {

	private static Scanner scanner;

	public static void main(String[] args) {
		scanner = new Scanner (System.in);
		int testCases = scanner.nextInt();
		
		for (int i = 0; i < testCases; i++) {
			System.out.println(passesTest(scanner.nextInt()));
		}
	}

	private static boolean passesTest(int nextInt) {
		int[] testArray = new int[nextInt];
		
		for (int i = 0; i < testArray.length; i++) {
			testArray[i] = scanner.nextInt();
		}
		
		for (int i = 0; i < testArray.length; i++) {
			int leftDigit = 0;
			int rightDigit = 0;
			if (i == 0){
				
			}
		}
		
		return true;
	}

}
