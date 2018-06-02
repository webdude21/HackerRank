package algorithms.hackerrangstring;

import java.util.Scanner;
import java.util.stream.IntStream;

public class Solution {

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int testCases = Integer.parseInt(scanner.nextLine());

    IntStream
      .range(0, testCases)
      .mapToObj(x -> scanner.nextLine())
      .map(x -> isWorkContainedInString(x, "hackerrank"))
      .map(x -> x ? "YES" : "NO")
      .forEach(System.out::println);
  }

  private static boolean isWorkContainedInString(String input, String wordToLookFor) {
    int lookupWordIndex = 0;

    for (int i = 0; i < input.length() && lookupWordIndex < wordToLookFor.length(); i++) {
      if (input.charAt(i) == wordToLookFor.charAt(lookupWordIndex)) {
        lookupWordIndex++;
      }
    }

    return lookupWordIndex == wordToLookFor.length();
  }
}
