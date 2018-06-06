package algorithms.maximumsubarraysum;

import java.util.Arrays;
import java.util.Scanner;

public class Solution {

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    long testCases = scanner.nextLong();
    scanner.nextLine();

    for (long i = 0; i < testCases; i++) {
      scanner.nextLong();
      long modulo = scanner.nextLong();
      scanner.nextLine();
      long[] array = Arrays.stream(scanner.nextLine().split(" "))
        .mapToLong(Long::valueOf)
        .toArray();
      System.out.println(maxSubArraySum(modulo, array));
    }
  }

  static long maxSubArraySum(long modulo, long[] input) {
    long maxSum = 0;

    for (int i = 0; i < input.length; i++) {
      long currentSum = 0;

      for (int j = i; j < input.length; j++) {
        currentSum += input[j];
        maxSum = Math.max(maxSum, currentSum % modulo);
      }
    }

    return maxSum;
  }
}
