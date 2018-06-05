package algorithms.minmaxsum;

import java.util.Arrays;
import java.util.Scanner;

public class Solution {

  private static final Scanner in = new Scanner(System.in);

  public static void main(String[] args) {
    int[] arr = new int[5];
    String[] arrItems = in.nextLine().split(" ");
    for (int i = 0; i < 5; i++) {
      int arrItem = Integer.parseInt(arrItems[i]);
      arr[i] = arrItem;
    }

    long[] result = miniMaxSum(arr);

    System.out.println(String.format("%d %d", result[0], result[1]));
  }

  private static long[] miniMaxSum(int[] arr) {
    long[] result = new long[2];
    Arrays.sort(arr);

    long sum = Arrays.stream(arr).mapToLong(value -> value).sum();
    result[0] = sum - arr[arr.length - 1];
    result[1] = sum - arr[0];

    return result;
  }
}
