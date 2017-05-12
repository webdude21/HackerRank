package algorithms.missingnumbers;

import java.util.ArrayList;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.TreeMap;
import java.util.stream.Collectors;

class Solution {

	private static Scanner scanner;

	public static void main(String[] args) {
		scanner = new Scanner(System.in);
		ArrayList<Integer> arrayList = extractMapDifferences(readArrayToAMap(), readArrayToAMap());
		System.out.println(arrayList.stream().map(Object::toString).collect(Collectors.joining(" ")));
	}

	private static ArrayList<Integer> extractMapDifferences(Map<Integer, Integer> aMap, Map<Integer, Integer> bMap) {
		ArrayList<Integer> arrayList = new ArrayList<>();

		for (Entry<Integer, Integer> entry : bMap.entrySet()) {
			int currentKey = entry.getKey();

			if (!aMap.containsKey(currentKey) || !aMap.get(currentKey).equals(bMap.get(currentKey))) {
				arrayList.add(currentKey);
			}
		}
		return arrayList;
	}

	private static Map<Integer, Integer> readArrayToAMap() {
		int values = scanner.nextInt();
		Map<Integer, Integer> sortedMap = new TreeMap<>();

		for (int i = 0; i < values; i++) {
			int nextValue = scanner.nextInt();
			if (!sortedMap.containsKey(nextValue)) {
				sortedMap.putIfAbsent(nextValue, 0);
			}

			sortedMap.put(nextValue, sortedMap.get(nextValue) + 1);
		}

		return sortedMap;
	}
}
