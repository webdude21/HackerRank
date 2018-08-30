package algorithms.minmax;

import java.util.Arrays;
import java.util.Scanner;

public class Solution {

  private static final Scanner scanner = new Scanner(System.in);

  public static void main(String[] args) {

    int n = scanner.nextInt();
    scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

    int k = scanner.nextInt();
    scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

    int[] arr = new int[n];

    for (int i = 0; i < n; i++) {
      int arrItem = scanner.nextInt();
      scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
      arr[i] = arrItem;
    }

    int result = maxMin(k, arr);

    System.out.println(result);

    scanner.close();
  }

  static int maxMin(int numbersToPick, int[] arr) {
    int minUnfairness = Integer.MAX_VALUE;

    Arrays.sort(arr);

    for (int i = 0; i <= arr.length - numbersToPick; i++) {
      int localMin = arr[i];
      int localMax = arr[i + numbersToPick - 1];

      minUnfairness = Math.min(localMax - localMin, minUnfairness);
    }

    return minUnfairness;
  }
}
