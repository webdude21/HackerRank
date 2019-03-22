package algorithms.anagram;

import java.util.Scanner;
import java.util.stream.IntStream;

public class Solution {

  private static final int ALLOWED_MAX_CHARACTERS = 26;

  static int anagram(String input) {
    if (input.length() % 2 != 0) {
      return -1;
    }

    int halfLength = input.length() / 2;

    int[] leftChars = toCharMap(input.substring(0, halfLength));
    int[] rightChars = toCharMap(input.substring(halfLength));

    return IntStream.range(0, ALLOWED_MAX_CHARACTERS)
      .map(i -> leftChars[i] - rightChars[i])
      .filter(diff -> diff > 0)
      .sum();
  }

  private static int[] toCharMap(String input) {
    int[] result = new int[ALLOWED_MAX_CHARACTERS];
    input.chars().forEach(value -> result[value - 'a']++);
    return result;
  }

  public static void main(String[] args) {
    try (Scanner scanner = new Scanner(System.in)) {
      int candidates = scanner.nextInt();
      scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
      IntStream.range(0, candidates).forEach(i -> System.out.println(anagram(scanner.nextLine())));
    }
  }
}
