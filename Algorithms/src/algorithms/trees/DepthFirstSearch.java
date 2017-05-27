package algorithms.trees;

import java.util.Iterator;
import java.util.Stack;

public class DepthFirstSearch<T extends Comparable<T>> implements Iterator<Node<T>> {

	private final Stack<Node<T>> nodeStack;

	DepthFirstSearch(Node<T> rootNode) {
		this.nodeStack = new Stack<>();
		nodeStack.push(rootNode);
	}

	@Override
	public boolean hasNext() {
		return nodeStack.size() > 0;
	}

	@Override
	public Node<T> next() {
		Node<T> resultNode = this.nodeStack.pop();
		resultNode.getDescendats().forEach(this.nodeStack::push);
		return resultNode;
	}
}
