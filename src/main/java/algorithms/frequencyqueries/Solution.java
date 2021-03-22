package algorithms.frequencyqueries;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {

  static final String FOUND = "1";
  static final String NOT_FOUND = "0";
  private final ArrayList<String> resultStore;
  private final Map<Integer, Integer> occurrenceMap = new HashMap<>();
  private final Map<Integer, Integer> reverseOccurrenceMap = new HashMap<>();

  public Solution(ArrayList<String> resultStore) {
    this.resultStore = resultStore;
  }

  public static void main(String[] args) throws IOException {
    try (BufferedReader bufferedReader = new BufferedReader(
      new InputStreamReader(System.in))) {

      int q = Integer.parseInt(bufferedReader.readLine().trim());
      Command[] commands = new Command[q];

      for (int i = 0; i < q; i++) {
        String[] query = bufferedReader.readLine().split(" ");
        commands[i] = Command.of(Integer.parseInt(query[0]), Integer.parseInt(query[1]));
      }

      System.out.println(String.join(System.lineSeparator(), frequencyQuery(commands)));
    }
  }

  static List<String> frequencyQuery(Command[] input) {
    Solution solution = new Solution(new ArrayList<>());
    Arrays.stream(input).forEach(command -> solution.interpretCommand(command, command.argument));
    return solution.resultStore;
  }

  private void interpretCommand(Command command, int argument) {
    switch (command.type) {
      case INSERT:
        insert(argument);
        break;
      case DELETE:
        delete(argument);
        break;
      case QUERY:
        query(argument);
        break;
    }
  }

  private void query(int argument) {
    resultStore.add(reverseOccurrenceMap.containsKey(argument) ? FOUND : NOT_FOUND);
  }

  private void updateReverseMap(int oldValue, int newValue) {
    reverseOccurrenceMap.computeIfPresent(oldValue, (key, value) -> value > 1 ? value - 1 : null);
    reverseOccurrenceMap.compute(newValue, (key, value) -> value == null ? 1 : value + 1);
  }

  private void delete(int argument) {
    occurrenceMap.computeIfPresent(argument, (key, value) -> {
      if (value > 0) {
        updateReverseMap(value, value - 1);
        return value - 1;
      } else {
        return null;
      }
    });
  }

  private void insert(int argument) {
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

    public int getCommandAsInt() {
      return commandAsInt;
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

    @Override
    public String toString() {
      return "Tuple{" +
        "a=" + type +
        ", b=" + argument +
        '}';
    }

    @Override
    public boolean equals(Object o) {
      if (this == o) return true;
      if (!(o instanceof Command)) return false;
      Command command = (Command) o;
      return type == command.type &&
        argument == command.argument;
    }

    @Override
    public int hashCode() {
      return Objects.hash(type, argument);
    }
  }
}
