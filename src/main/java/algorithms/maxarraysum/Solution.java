package algorithms.maxarraysum;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Solution {
  private static final Scanner scanner = new Scanner(System.in);

  public static int maxSubsetSum(int[] input) {
    int[] result = new int[input.length + 3];

    for (int i = input.length - 1; i >= 0; i--) {
      result[i] = Math.max(input[i] + result[i + 2], result[i + 1]);
    }

    return result[0];
  }

  public static void main(String[] args) throws IOException {
    BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

    int n = scanner.nextInt();
    scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

    int[] arr = new int[n];

    String[] arrItems = scanner.nextLine().split(" ");
    scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

    for (int i = 0; i < n; i++) {
      int arrItem = Integer.parseInt(arrItems[i]);
      arr[i] = arrItem;
    }

    int res = maxSubsetSum(arr);

    bufferedWriter.write(String.valueOf(res));
    bufferedWriter.newLine();

    bufferedWriter.close();

    scanner.close();
  }
}
