package algorithms.frequencyqueries;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {

  static final String FOUND = "1";
  static final String NOT_FOUND = "0";
  static final int INSERT = 1;
  static final int DELETE = 2;
  static final int QUERY = 3;
  private static final ArrayList<String> resultStore = new ArrayList<>();
  private static final Map<Integer, Integer> occurrenceMap = new HashMap<>();
  private static final Map<Integer, Integer> reverseOccurrenceMap = new HashMap<>();

  public static void main(String[] args) throws IOException {
    try (BufferedReader bufferedReader = new BufferedReader(
      new InputStreamReader(System.in))) {

      int q = Integer.parseInt(bufferedReader.readLine().trim());

      for (int i = 0; i < q; i++) {
        interpretCommand(bufferedReader.readLine());
      }

      System.out.println(String.join(System.lineSeparator(), resultStore));
    }
  }

  public static List<String> frequencyQuery(String[] input) {
    clearState();
    Arrays.stream(input).forEach(Solution::interpretCommand);
    return resultStore;
  }

  private static void clearState() {
    resultStore.clear();
    occurrenceMap.clear();
    reverseOccurrenceMap.clear();
  }

  private static void interpretCommand(String commandString) {
    String[] query = commandString.split(" ");
    int command = Integer.parseInt(query[0]);
    int argument = Integer.parseInt(query[1]);

    switch (command) {
      case INSERT:
        insert(argument);
        break;
      case DELETE:
        delete(argument);
        break;
      case QUERY:
        query(argument);
        break;
      default:
        throw new IllegalStateException("Unexpected value: " + command);
    }
  }

  private static void query(int argument) {
    resultStore.add(reverseOccurrenceMap.containsKey(argument) ? FOUND : NOT_FOUND);
  }

  private static void updateReverseMap(int oldValue, int newValue) {
    reverseOccurrenceMap.computeIfPresent(oldValue, (key, value) -> value > 1 ? value - 1 : null);
    reverseOccurrenceMap.compute(newValue, (key, value) -> value == null ? 1 : value + 1);
  }

  private static void delete(int argument) {
    occurrenceMap.computeIfPresent(argument, (key, value) -> {
      if (value > 0) {
        updateReverseMap(value, value - 1);
        return value - 1;
      } else {
        return null;
      }
    });
  }

  private static void insert(int argument) {
    occurrenceMap.compute(argument, (key, value) -> {
      if (value == null) {
        updateReverseMap(0, 1);
        return 1;
      } else {
        updateReverseMap(value, value + 1);
        return value + 1;
      }
    });
  }
}
