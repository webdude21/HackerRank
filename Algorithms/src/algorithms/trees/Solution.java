package algorithms.trees;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Solution {

	private static Map<Integer, Node<Integer>> nodeMap = new HashMap<>();

	private static Scanner scanner;

	public static void main(String[] args) {
		scanner = new Scanner(System.in);
		IntStream.range(0, scanner.nextInt()).forEach(x -> readInput());
		System.out.printf("The root is %s%n", findRoot());
		System.out.printf("The leafs are %s%n", formatOutput(findLeafs()));
		System.out.printf("The intermediates are %s%n", formatOutput(findIntermediates()));
	}

	private static void readInput() {
		int parentValue = scanner.nextInt();
		int childValue = scanner.nextInt();

		Node<Integer> parent = getNode(parentValue);
		Node<Integer> child = getNode(childValue);

		parent.addDescendant(child);
		child.setParent(parent);
	}

	private static Node<Integer> getNode(int value) {
		if (!nodeMap.containsKey(value)) {
			nodeMap.put(value, new Node<>(value));
		}

		return nodeMap.get(value);
	}

	private static Node<Integer> findRoot() {
		Node<Integer> startNode = nodeMap
				.values()
				.stream()
				.findAny()
				.orElseThrow(IllegalArgumentException::new);

		while (startNode.hasParent()) {
			startNode = startNode.getParent();
		}

		return startNode;
	}

	private static Stream<Node<Integer>> findLeafs() {
		return nodeMap
				.values()
				.stream()
				.filter(x -> x.descendantsCount() == 0);
	}

	private static Stream<Node<Integer>> findIntermediates() {
		return nodeMap
				.values()
				.stream()
				.filter(x -> x.descendantsCount() > 0 && x.hasParent());
	}

	private static String formatOutput(Stream<Node<Integer>> nodeStream) {
		return nodeStream
				.map(Node::toString)
				.collect(Collectors.joining(", "));
	}
}
