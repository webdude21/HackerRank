package algorithms.cityofblindinglights;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

class Solution {

  private static final Map<Integer, Map<Integer, Integer>> connectionsList = new HashMap<>();

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int nodeCount = scanner.nextInt();
    int edges = scanner.nextInt();

    for (int i = 0; i < edges; i++) {
      addConnection(scanner.nextInt(), scanner.nextInt(), scanner.nextInt());
    }
  }

  private static void addConnection(int sourceEdge, int targetEdge, int weight) {
    getNode(sourceEdge).put(getNode(targetEdge).get(targetEdge), weight);
  }

  private static Map<Integer, Integer> getNode(int id) {
    connectionsList.putIfAbsent(id, new HashMap<>());
    return connectionsList.get(id);
  }
}
