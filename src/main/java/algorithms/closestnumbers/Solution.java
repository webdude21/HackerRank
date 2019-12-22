package algorithms.closestnumbers;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Solution {
  static int[] closestNumbers(int[] input) {
    Arrays.sort(input);
    List<Integer> result = new ArrayList<>();
    int minGap = Integer.MAX_VALUE;

    for (int i = 1; i < input.length; i++) {
      minGap = Math.min(minGap, input[i] - input[i - 1]);
    }

    for (int i = 1; i < input.length; i++) {
      if (input[i] - input[i - 1] == minGap) {
        result.add(input[i - 1]);
        result.add(input[i]);
      }
    }

    return result.stream().mapToInt(i -> i).toArray();
  }

  private static final Scanner scanner = new Scanner(System.in);

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

    int[] result = closestNumbers(arr);

    for (int i = 0; i < result.length; i++) {
      bufferedWriter.write(String.valueOf(result[i]));

      if (i != result.length - 1) {
        bufferedWriter.write(" ");
      }
    }

    bufferedWriter.newLine();

    bufferedWriter.close();

    scanner.close();
  }
}
