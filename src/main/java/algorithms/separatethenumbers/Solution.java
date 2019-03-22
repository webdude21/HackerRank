package algorithms.separatethenumbers;

import java.util.Scanner;

public class Solution {

  private static final Scanner scanner = new Scanner(System.in);

  public static void main(String[] args) {
    int q = scanner.nextInt();
    scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

    for (int qItr = 0; qItr < q; qItr++) {
      String s = scanner.nextLine();
      System.out.println(separateNumbers(s));
    }

    scanner.close();
  }

  static String separateNumbers(String input) {
    try {
      return separateNumbers(input, 1);
    } catch (NumberFormatException e) {
      return "NO";
    }
  }

  private static String separateNumbers(String input, int initialStep) {
    int step = initialStep;
    int idx = initialStep;
    long previousNumber = Long.valueOf(input.substring(0, step));
    StringBuilder result = new StringBuilder("" + previousNumber);

    if (initialStep > input.length() / 2) {
      return "NO";
    }

    while (idx + step <= input.length()) {
      long newNumberCandidate = Long.valueOf(input.substring(idx, idx + step));

      if (previousNumber + 1 != newNumberCandidate) {
        step++;

        if (idx + step > input.length()) {
          break;
        }

        newNumberCandidate = Long.valueOf(input.substring(idx, idx + step));

        if (previousNumber + 1 != newNumberCandidate) {
          break;
        }
      }

      previousNumber = newNumberCandidate;
      result.append(previousNumber);
      idx += step;
    }

    if (result.length() == input.length()) {
      return "YES " + input.substring(0, initialStep);
    } else {
      return separateNumbers(input, initialStep + 1);
    }
  }
}
