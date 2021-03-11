package algorithms.simpletexteditor;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Solution {
  private static final String APPEND = "1";
  private static final String DELETE = "2";
  private static final String PRINT = "3";
  private static final String UNDO = "4";
  private static final StringBuilder resultBuilder = new StringBuilder();
  private static final Deque<String> state = new LinkedList<>();

  static {
    state.push("");
  }

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    int linesOfInput = Integer.parseInt(scanner.nextLine());

    for (int i = 0; i < linesOfInput; i++) {
      String[] commandArgs = scanner.nextLine().split("\\s+");
      if (commandArgs.length > 1) {
        executeCommand(commandArgs[0], commandArgs[1]);
      } else {
        executeCommand(commandArgs[0], null);
      }
    }

    System.out.print(resultBuilder.toString());
  }

  public static void executeCommand(String commandCode, String commandArgument) {
    final String currentState = state.peek();

    switch (commandCode) {
      case APPEND:
        state.push(append(currentState, commandArgument));
        break;
      case DELETE:
        state.push(delete(currentState, commandArgument));
        break;
      case UNDO:
        state.pop();
        break;
      case PRINT:
        print(currentState, commandArgument);
        break;
    }
  }

  private static String append(String currentState, String commandArgument) {
    return currentState + commandArgument;
  }

  private static String delete(String currentState, String commandArgument) {
    return currentState.substring(0, currentState.length() - Integer.parseInt(commandArgument));
  }

  private static void print(String currentState, String charToPrint) {
    resultBuilder.append(currentState.charAt(Integer.parseInt(charToPrint) - 1));
    resultBuilder.append(System.lineSeparator());
  }

  public static String executeCommands(List<List<String>> input) {
    input.forEach(strings -> executeCommand(strings.get(0), strings.size() > 1 ? strings.get(1) : null));
    return resultBuilder.toString().trim();
  }
}
