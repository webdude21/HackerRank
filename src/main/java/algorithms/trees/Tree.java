package algorithms.trees;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.StringJoiner;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Tree<T extends Comparable<T>> implements Iterable<Node<T>> {

  private final Map<T, Node<T>> nodeMap = new HashMap<>();

  public Node<T> getNode(T value) {
    if (!nodeMap.containsKey(value)) {
      nodeMap.put(value, new Node<>(value));
    }

    return nodeMap.get(value);
  }

  public Node<T> findRoot() {
    Node<T> startNode = nodeMap
      .values()
      .stream()
      .findAny()
      .orElseThrow(IllegalArgumentException::new);

    while (startNode.hasParent()) {
      startNode = startNode.getParent();
    }

    return startNode;
  }

  public Stream<Node<T>> findLeafs() {
    return filterNodes(x -> x.descendantsCount() == 0);
  }

  public Stream<Node<T>> findIntermediates() {
    return filterNodes(x -> x.descendantsCount() > 0 && x.hasParent());
  }

  public String formatOutput(Stream<Node<T>> nodeStream) {
    return nodeStream
      .map(Node::toString)
      .collect(Collectors.joining(", "));
  }

  @Override
  public Iterator<Node<T>> iterator() {
    return new BreadthFirstSearch<>(findRoot());
  }

  @Override
  public String toString() {
    StringJoiner stringJoiner = new StringJoiner(", ", "[", "]");

    for (Node<T> node : this) {
      stringJoiner.add(node.toString());
    }

    return stringJoiner.toString();
  }

  private Stream<Node<T>> filterNodes(Predicate<Node<T>> nodePredicate) {
    return nodeMap
      .values()
      .stream()
      .filter(nodePredicate);
  }
}
