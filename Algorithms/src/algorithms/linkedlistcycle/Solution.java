package algorithms.linkedlistcycle;

import java.util.HashSet;
import java.util.Set;

public class Solution {

	boolean hasCycle(Node head) {
		Set<Node> visitedNodes = new HashSet<>();

		while (head != null) {
			if (visitedNodes.contains(head)) {
				return true;
			}

			visitedNodes.add(head);
			head = head.next;
		}

		return false;
	}

	class Node {
		int data;

		Node next;
	}
}
