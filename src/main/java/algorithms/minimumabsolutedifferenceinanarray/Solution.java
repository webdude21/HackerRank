package algorithms.minimumabsolutedifferenceinanarray;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Solution {

  private static final Scanner scanner = new Scanner(System.in);

  public static void main(String[] args) {

    int n = scanner.nextInt();
    scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

    int[] arr = new int[n];

    String[] arrItems = scanner.nextLine().split(" ");
    scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

    for (int i = 0; i < n; i++) {
      int arrItem = Integer.parseInt(arrItems[i]);
      arr[i] = arrItem;
    }

    int result = minimumAbsoluteDifference(arr);

    System.out.println(String.valueOf(result));

    scanner.close();
  }

  static int minimumAbsoluteDifference(int[] input) {
    final List<Integer> integers = Arrays.stream(input)
      .boxed()
      .sorted(Collections.reverseOrder())
      .collect(Collectors.toList());

    return findMinAbsoluteDifference(integers);
  }

  private static int findMinAbsoluteDifference(List<Integer> integers) {
    int result = Integer.MAX_VALUE;

    for (int i = 1; i < integers.size() - 1; i++) {
      result = Math.min(result, Math.abs(integers.get(i - 1) - integers.get(i)));
    }

    return result;
  }
}
