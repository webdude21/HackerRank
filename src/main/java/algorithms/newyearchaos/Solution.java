package algorithms.newyearchaos;

import java.util.Scanner;

import static java.lang.Math.max;

public class Solution {

  private static final Scanner scanner = new Scanner(System.in);

  public static void main(String[] args) {
    int t = scanner.nextInt();
    scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

    for (int tItr = 0; tItr < t; tItr++) {
      int n = scanner.nextInt();
      scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

      int[] q = new int[n];

      String[] qItems = scanner.nextLine().split(" ");
      scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

      for (int i = 0; i < n; i++) {
        int qItem = Integer.parseInt(qItems[i]);
        q[i] = qItem;
      }

      System.out.println(minimumBribes(q));
    }

    scanner.close();
  }

  static String minimumBribes(int[] input) {
    int result = 0;

    for (int i = input.length - 1; i >= 0; i--) {
      if (input[i] - (i + 1) > 2) {
        return "Too chaotic";
      }

      for (int j = max(0, input[i] - 2); j < i; j++) {
        if (input[j] > input[i]) {
          result++;
        }
      }
    }

    return Integer.toString(result);
  }
}
