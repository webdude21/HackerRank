package algorithms.finddigits;

import java.util.Scanner;
import java.util.stream.IntStream;

class Solution {

  private static Scanner scanner;

  public static void main(String[] args) {
    scanner = new Scanner(System.in);
    IntStream.range(0, scanner.nextInt()).forEach(x -> System.out.println(testNumber(scanner.nextInt())));
  }

  private static int testNumber(int input) {
    char[] digits = String.valueOf(input).toCharArray();
    int result = 0;

    for (char c : digits) {
      int digit = c - '0';
      if (digit > 0 && input % digit == 0) {
        result++;
      }
    }
    return result;
  }
}
