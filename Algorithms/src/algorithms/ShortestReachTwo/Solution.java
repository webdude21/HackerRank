package algorithms.ShortestReachTwo;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution {

    private static Scanner scanner;

    public class Graph<T extends Comparable<T>> {
        private final List<Edge<T>> edgeList;
        private final List<Node<T>> nodeList;

        public Graph() {
            nodeList = new ArrayList<>();
            edgeList = new ArrayList<>();
        }

        public List<Edge<T>> getEdgeList() {
            return edgeList;
        }

        public List<Node<T>> getNodeList() {
            return nodeList;
        }
    }

    public class Edge<T extends Comparable<T>> implements Comparable<Edge<T>> {

        private Node<T> target;
        private Node<T> source;
        private int weight;

        public Edge(Node<T> source, Node<T> target, int weight) {
            setSource(source);
            setTarget(target);
            setWeight(weight);
        }

        public Node<T> getTarget() {
            return target;
        }

        public void setTarget(Node<T> target) {
            this.target = target;
        }

        public Node<T> getSource() {
            return source;
        }

        public void setSource(Node<T> source) {
            this.source = source;
        }

        public int getWeight() {
            return weight;
        }

        public void setWeight(int weight) {
            this.weight = weight;
        }

        @Override
        public String toString() {
            return String.format("%s -(%s)-> %s", getTarget(), getWeight(), getSource());
        }

        @Override
        public int compareTo(Edge<T> o) {
            if (o != null) {
                return this.getWeight() - o.getWeight();
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
    }

    public class Node<T extends Comparable<T>> implements Comparable<Node<T>> {

        private T id;

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof Node)) return false;

            Node<?> node = (Node<?>) o;

            return getId().equals(node.getId());

        }

        @Override
        public int hashCode() {
            return getId().hashCode();
        }

        public Node(T id) {
            setId(id);
        }

        @Override
        public int compareTo(Node<T> o) {
            if (o != null) {
                o.getId().compareTo(this.getId());
            }

            return 0;
        }

        public T getId() {
            return id;
        }

        public void setId(T id) {
            this.id = id;
        }
    }
}
