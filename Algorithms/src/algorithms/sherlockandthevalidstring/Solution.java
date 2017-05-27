package algorithms.sherlockandthevalidstring;

import java.util.*;

class Solution {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		PrintResult(checkIfValid(convertToListOfOccurrences(scanner.nextLine())));
	}

	private static boolean checkIfValid(List<Integer> listOfOccurrences) {
		int lastOccurrence = 0;

		for (int occurrence : listOfOccurrences) {
			if (lastOccurrence == 0) {
				lastOccurrence = occurrence;
			}

			if (occurrence != lastOccurrence) {
				return false;
			}
		}

		return checkIfCanBeModifiedToValid(listOfOccurrences);
	}

	private static boolean checkIfCanBeModifiedToValid(List<Integer> listOfOccurrences) {
		for (int i = 0; i < listOfOccurrences.size(); i++) {
			int itemToTryWithout = listOfOccurrences.remove(i);

			if (checkIfValid(listOfOccurrences)) {
				return true;
			}

			listOfOccurrences.add(i, itemToTryWithout);
		}
		return false;
	}

	private static List<Integer> convertToListOfOccurrences(String input) {
		Map<Character, Integer> map = new HashMap<>();

		for (int i = 0; i < input.length(); i++) {
			char currentChar = input.charAt(i);
			if (!map.containsKey(currentChar)) {
				map.put(currentChar, 1);
			} else {
				map.put(currentChar, map.get(currentChar) + 1);
			}
		}

		return new ArrayList<>(map.values());
	}

	private static void PrintResult(Boolean validString) {
		System.out.println(validString ? "YES" : "NO");
	}
}