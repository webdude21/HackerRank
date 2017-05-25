package algorithms.timeinwords;

import java.util.Scanner;

public class Solution {

	private static String[] digits = new String[]{"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine", "ten", "eleven", "twelve",
			"thirteen", "fourteen", "fifteen", "sixteen", "seventeen", "eighteen", "nineteen", "twenty",
			"twenty one", "twenty two", "twenty three", "twenty four", "twenty five", "twenty six", "twenty seven",
			"twenty eight", "twenty nine"};

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int hours = Integer.parseInt(scanner.nextLine());
		int minutes = Integer.parseInt(scanner.nextLine());
		System.out.print(getTimeAsString(hours, minutes));
	}

	private static String getTimeAsString(int hours, int minutes) {
		if (minutes == 0) {
			return String.format("%s o' clock", digits[hours]);
		}

		if (minutes == 30) {
			return String.format("half past %s", digits[hours]);
		}

		if (minutes < 30) {
			return String.format("%s past %s", getMinutesAsString(minutes), digits[hours]);
		} else {
			return String.format("%s to %s", getMinutesAsString(60 - minutes), digits[hours + 1]);
		}
	}

	private static String getMinutesAsString(int minutes) {
		if (minutes == 0) {
			return null;
		}

		if (minutes == 45 || minutes == 15) {
			return "quarter";
		}

		return minutes == 1 ? "one minute" : String.format("%s minutes", digits[minutes]);
	}
}
