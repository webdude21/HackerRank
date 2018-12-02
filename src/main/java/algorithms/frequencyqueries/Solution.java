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

  public Solution(ArrayList<String> resultStore) {
    this.resultStore = resultStore;
  }

  enum CommandType {
    INSERT(1),
    DELETE(2),
    QUERY(3);

    private int commandAsInt;

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
    occurrenceMap.putIfAbsent(argument, 0);

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
    boolean found = occurrenceMap.entrySet().stream()
      .anyMatch(keyValuePair -> keyValuePair.getValue().equals(argument));
    resultStore.add(found ? FOUND : NOT_FOUND);
  }

  private void delete(int argument) {
    occurrenceMap.computeIfPresent(argument, (key, value) -> value > 0 ? value - 1 : 0);
  }

  private void insert(int argument) {
    occurrenceMap.computeIfPresent(argument, (key, value) -> value + 1);
  }

  static class Command {
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
      return this.type == command.type &&
        argument == command.argument;
    }

    @Override
    public int hashCode() {
      return Objects.hash(type, argument);
    }

    private final CommandType type;
    private final int argument;

    Command(CommandType commandType, int argument) {
      this.type = commandType;
      this.argument = argument;
    }

    public static Command of(int commandAsInt, int argument) {
      return new Command(CommandType.valueOf(commandAsInt), argument);
    }
  }
}
