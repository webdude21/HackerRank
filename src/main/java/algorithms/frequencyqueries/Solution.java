package algorithms.frequencyqueries;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {

  static final String FOUND = "1";
  static final String NOT_FOUND = "0";
  private static final ArrayList<String> resultStore = new ArrayList<>();
  private static final Map<Integer, Integer> occurrenceMap = new HashMap<>();
  private static final Map<Integer, Integer> reverseOccurrenceMap = new HashMap<>();

  public static void main(String[] args) throws IOException {
    try (BufferedReader bufferedReader = new BufferedReader(
      new InputStreamReader(System.in))) {

      int q = Integer.parseInt(bufferedReader.readLine().trim());

      for (int i = 0; i < q; i++) {
        String[] query = bufferedReader.readLine().split(" ");
        interpretCommand(Command.of(Integer.parseInt(query[0]), Integer.parseInt(query[1])));
      }

      System.out.println(String.join(System.lineSeparator(), resultStore));
    }
  }

  public static List<String> frequencyQuery(Command[] input) {
    clearState();
    Arrays.stream(input).forEach(Solution::interpretCommand);
    return resultStore;
  }

  private static void clearState() {
    resultStore.clear();
    occurrenceMap.clear();
    reverseOccurrenceMap.clear();
  }

  private static void interpretCommand(Command command) {
    switch (command.type) {
      case INSERT:
        insert(command.argument);
        break;
      case DELETE:
        delete(command.argument);
        break;
      case QUERY:
        query(command.argument);
        break;
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

  enum CommandType {
    INSERT(1),
    DELETE(2),
    QUERY(3);

    private final int commandAsInt;

    CommandType(int commandAsInt) {
      this.commandAsInt = commandAsInt;
    }

    static CommandType valueOf(int commandAsInt) {
      switch (commandAsInt) {
        case 1:
          return INSERT;
        case 2:
          return DELETE;
        case 3:
          return QUERY;
        default:
          throw new IllegalArgumentException(commandAsInt + " is not a valid command type!");
      }
    }
  }

  static class Command {
    private final CommandType type;
    private final int argument;

    Command(CommandType commandType, int argument) {
      type = commandType;
      this.argument = argument;
    }

    public static Command of(int commandAsInt, int argument) {
      return new Command(CommandType.valueOf(commandAsInt), argument);
    }
  }
}
