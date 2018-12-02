package algorithms.frequencyqueries;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

public class Solution {

  private final ArrayList<Integer> resultStore;
  private final Map<Integer, Integer> occurrenceMap = new HashMap<>();

  public Solution(ArrayList<Integer> resultStore) {
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

    static public Optional<CommandType> valueOf(int commandAsInt) {
      return Arrays.stream(CommandType.values())
        .filter(commandType -> commandType.commandAsInt == commandAsInt)
        .findAny();
    }
  }

  private static List<Integer> freqQuery(List<List<Integer>> queries) {
    final Command[] commands = queries.stream().map(query -> Command.of(query.get(0), query.get(1))).toArray(Command[]::new);
    return frequencyQuery(commands);
  }

  public static void main(String[] args) throws IOException {
    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

    int q = Integer.parseInt(bufferedReader.readLine().trim());

    List<List<Integer>> queries = new ArrayList<>();

    IntStream.range(0, q).forEach(i -> {
      try {
        queries.add(
          Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
            .map(Integer::parseInt)
            .collect(toList())
        );
      } catch (IOException ex) {
        throw new RuntimeException(ex);
      }
    });

    List<Integer> ans = freqQuery(queries);

    ans.forEach(System.out::println);
  }

  static List<Integer> frequencyQuery(Command[] input) {
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
    boolean exists = occurrenceMap.entrySet().stream()
      .anyMatch(keyValuePair -> keyValuePair.getValue().equals(argument));

    resultStore.add(exists ? 1 : 0);
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
      final CommandType commandType = CommandType.valueOf(commandAsInt)
        .orElseThrow(() -> new IllegalArgumentException(commandAsInt + " is not a valid command type!"));
      return new Command(commandType, argument);
    }
  }
}
