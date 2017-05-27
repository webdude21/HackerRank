package algorithms.trees;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

public class BreadthFirstSearch<T extends Comparable<T>> implements Iterator<Node<T>> {

	private final Queue<Node<T>> nodeQueue;

	BreadthFirstSearch(Node<T> rootNode) {
		this.nodeQueue = new LinkedList<>();
		nodeQueue.add(rootNode);
	}

	@Override
	public boolean hasNext() {
		return nodeQueue.size() > 0;
	}

	@Override
	public Node<T> next() {
		Node<T> resultNode = this.nodeQueue.poll();
		this.nodeQueue.addAll(resultNode.getDescendats());
		return resultNode;
	}
}