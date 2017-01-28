package algorithms.checkforbinarytree;

public class Solution {

	boolean check(Node n, int min, int max) {
		return n == null || !(n.data <= min || n.data >= max) && check(n.left, min, n.data) && check(n.right, n.data, max);
	}

	boolean checkBST(Node root) {
		return check(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
	}

	class Node {
		int data;

		Node left;

		Node right;
	}
}
