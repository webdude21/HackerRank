package algorithms.cutthesticks;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Solution {

	public static void main(String[] args) {
		List<Integer> sticks = readInput();

		while (sticks.size() > 0) {
			System.out.println(sticks.size());
			sticks = reduceSticks(sticks);
		}
	}

	private static List<Integer> reduceSticks(List<Integer> sticks) {
		int smallestStick = sticks.stream().min(Integer::compareTo).orElse(0);
		return sticks
				.stream()
				.map(length -> length - smallestStick)
				.filter(length -> length > 0)
				.collect(Collectors.toList());
	}

	private static ArrayList<Integer> readInput() {
		Scanner scanner = new Scanner(System.in);
		int sticksCount = scanner.nextInt();
		ArrayList<Integer> sticks = new ArrayList<>();

		for (int i = 0; i < sticksCount; i++) {
			sticks.add(scanner.nextInt());
		}

		return sticks;
	}
}
