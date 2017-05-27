package algorithms.trees;

import java.util.Scanner;
import java.util.stream.IntStream;

public class Solution {

	private static Tree<Integer> tree = new Tree<>();

	private static Scanner scanner;

	public static void main(String[] args) {
		scanner = new Scanner(System.in);
		IntStream.range(0, scanner.nextInt()).forEach(x -> readInput());
		System.out.printf("The root is %s%n", tree.findRoot());
		System.out.printf("The leafs are %s%n", tree.formatOutput(tree.findLeafs()));
		System.out.printf("The intermediates are %s%n", tree.formatOutput(tree.findIntermediates()));
	}

	private static void readInput() {
		int parentValue = scanner.nextInt();
		int childValue = scanner.nextInt();

		Node<Integer> parent = tree.getNode(parentValue);
		Node<Integer> child = tree.getNode(childValue);

		parent.addDescendant(child);
		child.setParent(parent);
	}
}
