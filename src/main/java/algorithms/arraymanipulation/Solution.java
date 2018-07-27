package algorithms.arraymanipulation;

import java.util.Scanner;

public class Solution {

  static long arrayManipulation(int n, int[][] queries) {
    long[] stateArray = new long[n];

    for (int[] query : queries) {
      int startIndex = query[0] - 1;
      int endIndex = query[1];
      int summand = query[2];

      stateArray[startIndex] += summand;

      if (endIndex < n) {
        stateArray[endIndex] -= summand;
      }
    }

    long max = 0;
    long temp = 0;

    for (int i = 0; i < n; i++) {
      temp += stateArray[i];
      max = Math.max(temp, max);
    }

    return max;
  }

  private static final Scanner scanner = new Scanner(System.in);

  public static void main(String[] args) {
    String[] nm = scanner.nextLine().split(" ");

    int n = Integer.parseInt(nm[0]);

    int m = Integer.parseInt(nm[1]);

    int[][] queries = new int[m][3];

    for (int i = 0; i < m; i++) {
      String[] queriesRowItems = scanner.nextLine().split(" ");
      scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

      for (int j = 0; j < 3; j++) {
        int queriesItem = Integer.parseInt(queriesRowItems[j]);
        queries[i][j] = queriesItem;
      }
    }

    long result = arrayManipulation(n, queries);

    System.out.println(result);

    scanner.close();
  }
}
