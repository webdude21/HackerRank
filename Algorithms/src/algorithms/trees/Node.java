package algorithms.trees;

import java.util.Collection;
import java.util.LinkedList;

public class Node<T extends Comparable<T>> implements Comparable<T> {

	private final T value;

	private final LinkedList<Node<T>> descendants;

	private Node<T> parent;

	public Node(T value) {
		this.value = value;
		descendants = new LinkedList<>();
	}

	public Node<T> getParent() {
		return parent;
	}

	public void setParent(Node<T> parent) {
		this.parent = parent;
	}

	public T getValue() {
		return value;
	}

	public int descendantsCount() {
		return descendants.size();
	}

	public boolean hasParent() {
		return this.parent != null;
	}

	@Override
	public int compareTo(T o) {
		return value.compareTo(o);
	}

	@Override
	public String toString() {
		return String.format("Node = %s", this.getValue().toString());
	}

	public void addDescendant(Node<T> node) {
		this.descendants.add(node);
	}

	public Collection<Node<T>> getDescendats() {
		return descendants;
	}
}
