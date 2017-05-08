package algorithms.makinganagrams;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Solution {

	private static int numberNeeded(String first, String second) {
		Map<Character, Integer> charMap = getCharacterMap(first);

		int count = 0;

		for (char c : second.toCharArray()) {
			if (!charMap.containsKey(c) || charMap.containsKey(c) && charMap.get(c) == 0) {
				count++;
			} else {
				if (charMap.containsKey(c) && charMap.get(c) > 0) {
					Integer current = charMap.get(c);
					current--;
					charMap.put(c, current);
				}
			}
		}

		for (Integer value : charMap.values()) {
			count = count + value;
		}

		return count;
	}

	private static Map<Character, Integer> getCharacterMap(String value) {
		Map<Character, Integer> charMap = new HashMap<>();

		for (char c : value.toCharArray()) {
			if (!charMap.containsKey(c)) {
				charMap.put(c, 1);
			} else {
				Integer current = charMap.get(c);
				current++;
				charMap.put(c, current);
			}
		}

		return charMap;
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		String a = in.next();
		String b = in.next();
		System.out.println(numberNeeded(a, b));
	}
}