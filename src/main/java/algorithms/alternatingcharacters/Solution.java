package algorithms.alternatingcharacters;

import java.util.Scanner;

public class Solution {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    final int testCases = scanner.nextInt();
    scanner.nextLine();

    for (int i = 0; i < testCases; i++) {
      System.out.println(solve(scanner.nextLine()));
    }
  }

  public static int solve(String input) {
    int deletions = 0;
    char prevChar = input.charAt(0);

    for (int i = 1; i < input.length(); i++) {
      char currentChar = input.charAt(i);

      if (prevChar == currentChar) {
        deletions++;
      } else {
        prevChar = currentChar;
      }
    }

    return deletions;
  }
}
