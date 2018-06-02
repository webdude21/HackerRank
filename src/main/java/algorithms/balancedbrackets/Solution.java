package algorithms.balancedbrackets;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Stack;

class Solution {

  private static final Map<Character, Character> bracketPairs = new HashMap<>();

  public static void main(String[] args) {
    bracketPairs.put('{', '}');
    bracketPairs.put('[', ']');
    bracketPairs.put('(', ')');

    Scanner in = new Scanner(System.in);
    int lines = in.nextInt();

    for (int i = 0; i < lines; i++) {
      System.out.println((isBalanced(in.next())) ? "YES" : "NO");
    }
  }

  private static boolean isBalanced(String expression) {
    if (expression.length() % 2 == 1) {
      return false;
    }

    char[] brackets = expression.toCharArray();
    Stack<Character> bracketsToClose = new Stack<>();

    for (char bracket : brackets) {
      if (bracketPairs.containsKey(bracket)) {
        bracketsToClose.push(bracketPairs.get(bracket));
      } else {
        if (bracketsToClose.empty() || bracket != bracketsToClose.peek()) {
          return false;
        }
        bracketsToClose.pop();
      }
    }

    return bracketsToClose.empty();
  }
}
