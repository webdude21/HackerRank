package algorithms.largestrectangle;

import java.util.Scanner;

public class Solution {

  private static final Scanner scanner = new Scanner(System.in);

  public static void main(String[] args) {
    int n = scanner.nextInt();
    scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

    int[] h = new int[n];

    String[] hItems = scanner.nextLine().split(" ");
    scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

    for (int i = 0; i < n; i++) {
      int hItem = Integer.parseInt(hItems[i]);
      h[i] = hItem;
    }

    long result = largestRectangle(h);

    System.out.println(result);

    scanner.close();
  }

  static int largestRectangle(int[] input) {
    int maxArea = Integer.MIN_VALUE;

    for (int i = 0; i < input.length; i++) {
      int localMin = Integer.MAX_VALUE;

      for (int j = i; j < input.length; j++) {
        localMin = Math.min(input[j], localMin);
        maxArea = Math.max((j + 1 - i) * localMin, maxArea);
      }
    }

    return maxArea;
  }
}
