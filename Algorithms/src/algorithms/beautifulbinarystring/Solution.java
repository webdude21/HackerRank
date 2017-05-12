package algorithms.beautifulbinarystring;

import java.util.Scanner;

class Solution {

	private static final String UGLY = "010";

	private static final String MULTI_UGLY = "01010";

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		// Ignore the first line, don't really need the length of the string
		scanner.nextLine();
		System.out.println(findModificationCount(scanner.nextLine()));
	}

	private static int findModificationCount(String binaryString) {
		int modificationCount = 0;

		while (isUgly(binaryString)) {
			binaryString = beautify(binaryString);
			modificationCount++;
		}

		return modificationCount;
	}

	private static String beautify(String binaryString) {
		StringBuilder beautifulString = new StringBuilder(binaryString);
		int indexToChange = binaryString.indexOf(MULTI_UGLY);

		if (indexToChange > -1) {
			beautifulString.setCharAt(indexToChange + 2, '1');
		} else {
			indexToChange = binaryString.indexOf(UGLY);
			beautifulString.setCharAt(indexToChange + 1, '0');
		}

		return beautifulString.toString();
	}

	private static boolean isUgly(String string) {
		return string.contains(UGLY);
	}
}
