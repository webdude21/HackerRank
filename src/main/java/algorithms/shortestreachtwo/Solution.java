package algorithms.shortestreachtwo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

class Solution {

  public static void main(String[] arguments) {
    Scanner scanner = new Scanner(System.in);
    int testCases = scanner.nextInt();
    int nodes = scanner.nextInt();
    int edges = scanner.nextInt();
    Graph<Integer> graph = new Graph<>();

    for (int i = 0; i < edges; i++) {
      Node<Integer> source = graph.getNode(scanner.nextInt());
      Node<Integer> target = graph.getNode(scanner.nextInt());
      int weight = scanner.nextInt();
      graph.getEdgeList().add(new Edge<>(source, target, weight));
      source.addConnection(target, weight);
    }

    System.out.println(graph);
  }

  private static class Graph<T extends Comparable<T>> {
    private final List<Edge<T>> edgeList;

    private final HashMap<T, Node<T>> nodeList;

    Graph() {
      nodeList = new HashMap<>();
      edgeList = new ArrayList<>();
    }

    @Override
    public String toString() {
      return getEdgeList()
        .stream()
        .map(Edge::toString)
        .collect(Collectors.joining(String.format("%n")));
    }

    HashMap<T, Node<T>> getNodeList() {
      return nodeList;
    }

    List<Edge<T>> getEdgeList() {
      return edgeList;
    }

    Node<T> getNode(T id) {
      getNodeList().putIfAbsent(id, new Node<>(id));
      return getNodeList().get(id);
    }
  }

  static class Edge<T extends Comparable<T>> implements Comparable<Edge<T>> {

    private Node<T> target;

    private Node<T> source;

    private int weight;

    Edge(Node<T> source, Node<T> target, int weight) {
      setSource(source);
      setTarget(target);
      setWeight(weight);
    }

    @Override
    public String toString() {
      return String.format("%s -(%s)-> %s", getSource().getId(), getWeight(), getTarget().getId());
    }

    @Override
    public int compareTo(Edge<T> o) {
      if (o != null) {
        return getWeight() - o.getWeight();
      }

      return 0;
    }

    @Override
    public boolean equals(Object o) {
      if (this == o) return true;
      if (!(o instanceof Edge)) return false;

      Edge<?> edge = (Edge<?>) o;

      return getWeight() == edge.getWeight() &&
        getTarget().equals(edge.getTarget()) &&
        getSource().equals(edge.getSource());
    }

    @Override
    public int hashCode() {
      int result = getTarget().hashCode();
      result = 31 * result + getSource().hashCode();
      result = 31 * result + getWeight();
      return result;
    }

    Node<T> getTarget() {
      return target;
    }

    void setTarget(Node<T> target) {
      this.target = target;
    }

    Node<T> getSource() {
      return source;
    }

    void setSource(Node<T> source) {
      this.source = source;
    }

    int getWeight() {
      return weight;
    }

    void setWeight(int weight) {
      this.weight = weight;
    }
  }

  static class Node<T extends Comparable<T>> implements Comparable<Node<T>> {

    private final List<Edge<T>> connections;

    private T id;

    Node(T id) {
      connections = new ArrayList<>();
      setId(id);
    }

    @Override
    public boolean equals(Object o) {
      if (this == o) return true;
      if (!(o instanceof Node)) return false;

      Node<?> node = (Node<?>) o;

      return node.getId().equals(getId());

    }

    @Override
    public String toString() {
      return getConnections().stream().map(Edge::toString).collect(Collectors.joining(String.format("%n")));
    }

    @Override
    public int hashCode() {
      return getId().hashCode();
    }

    @Override
    public int compareTo(Node<T> o) {
      if (o != null) {
        o.getId().compareTo(getId());
      }

      return 0;
    }

    List<Edge<T>> getConnections() {
      return connections;
    }

    void addConnection(Node<T> targetNode, int weight, boolean twoWay) {
      if (targetNode == null) {
        throw new IllegalArgumentException("Target must not be null");
      }

      if (targetNode.equals(this)) {
        throw new IllegalArgumentException("Node may not connect to itself.");
      }

      if (weight < 0) {
        throw new IllegalArgumentException("Weight must be positive.");
      }

      getConnections().add(new Edge<>(this, targetNode, weight));

      if (twoWay) {
        targetNode.addConnection(this, weight, false);
      }
    }

    void addConnection(Node<T> targetNode, int weight) {
      addConnection(targetNode, weight, false);
    }

    T getId() {
      return id;
    }

    void setId(T id) {
      this.id = id;
    }
  }
}
