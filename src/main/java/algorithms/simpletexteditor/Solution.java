package algorithms.simpletexteditor;

import java.util.*;

public class Solution {

  private static StringBuilder result;
  private static StringBuilder sb;

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int linesOfInput = Integer.parseInt(scanner.nextLine());
    List<List<String>> commands = new ArrayList<>();

    for (int i = 0; i < linesOfInput; i++) {
      String[] commandArgs = scanner.nextLine().split("\\s+");
      if (commandArgs.length > 1) {
        commands.add(Arrays.asList(commandArgs[0], commandArgs[1]));
      } else {
        commands.add(Collections.singletonList(commandArgs[0]));
      }
    }

    printResult(executeCommands(commands));
  }

  private static void printResult(char[] result) {
    sb = new StringBuilder();

    for (char character : result) {
      sb.append(character);
      sb.append(System.lineSeparator());
    }

    System.out.println(sb.toString());
  }

  public static char[] executeCommands(List<List<String>> commands) {
    result = new StringBuilder();

    Deque<String> state = new LinkedList<>();

    state.push("");

    for (List<String> strings : commands) {
      Command command = parseCommand(strings);
      switch (command.getCommandCode()) {
        case Command.APPEND:
        case Command.DELETE:
          state.push(renderState(command, state.peek()));
          break;
        case Command.UNDO:
          state.pop();
          break;
        case Command.PRINT:
          print(Objects.requireNonNull(state.peek()), command.commandArgument);
          break;
      }
    }

    return result.toString().toCharArray();
  }

  private static String renderState(Command command, String currentState) {
    sb = new StringBuilder(currentState);

    final String commandCode = command.getCommandCode();
    final String commandArgument = command.commandArgument;
    if (commandCode.equals(Command.APPEND)) {
      append(commandArgument);
    } else if (commandCode.equals(Command.DELETE)) {
      delete(commandArgument);
    }

    return sb.toString();
  }

  private static void append(String commandArgument) {
    sb.append(commandArgument);
  }

  private static void delete(String commandArgument) {
    sb.delete(sb.length() - Integer.parseInt(commandArgument), sb.length());
  }

  private static void print(String currentState, String charToPrint) {
    result.append(currentState.charAt(Integer.parseInt(charToPrint) - 1));
  }

  private static Command parseCommand(List<String> input) {
    return new Command(input.get(0), input.size() > 1 ? input.get(1) : null);
  }

  static class Command {
    static final String APPEND = "1";
    static final String DELETE = "2";
    static final String PRINT = "3";
    static final String UNDO = "4";

    private final String commandArgument;
    private final String commandCode;

    public Command(String commandCode, String commandArgument) {
      this.commandCode = commandCode;
      this.commandArgument = commandArgument;
    }

    public String getCommandCode() {
      return this.commandCode;
    }
  }
}
