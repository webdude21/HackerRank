package algorithms.queueusingstacks;

import java.util.*;

public class Solution {

  private static final int ENQUEUE = 1;
  private static final int DEQUEUE = 2;
  private static final int PRINT = 3;

  private static final String WHITE_SPACE = "\\s+";

  private static Stack<Integer> head;
  private static Stack<Integer> tail;

  private static final Scanner scanner = new Scanner(System.in);

  public static void main(String[] args) {
    int queries = Integer.valueOf(scanner.nextLine());
    int[][] parsedQueries = new int[queries][];

    for (int i = 0; i < queries; i++) {
      final String[] query = scanner.nextLine().split(WHITE_SPACE);
      int[] parsedQuery = new int[2];
      parsedQuery[0] = Integer.valueOf(query[0]);

      if (query.length > 1) {
        parsedQuery[1] = Integer.valueOf(query[1]);
      }

      parsedQueries[i] = parsedQuery;
    }

    final int[] result = processQueries(parsedQueries);

    Arrays.stream(result).forEach(System.out::println);
  }

  static int[] processQueries(int[][] queries) {
    List<Integer> results = new ArrayList<>();
    head = new Stack<>();
    tail = new Stack<>();

    for (int[] queryPair : queries) {
      int command = queryPair[0];
      int argument = queryPair[1];

      switch (command) {
        case ENQUEUE:
          enqueue(argument);
          break;
        case DEQUEUE:
          dequeue();
          break;
        case PRINT:
          results.add(peek());
          break;
      }
    }

    return results.stream().mapToInt(Integer::valueOf).toArray();
  }

  private static int peek() {
    if (tail.isEmpty()) {
      shift();
    }

    return tail.peek();
  }

  private static void dequeue() {
    if (tail.isEmpty()) {
      shift();
    }

    tail.pop();
  }

  private static void shift() {
    while (!head.isEmpty()) {
      tail.push(head.pop());
    }
  }

  private static void enqueue(int argument) {
    head.push(argument);
  }
}

