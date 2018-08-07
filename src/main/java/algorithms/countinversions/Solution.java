package algorithms.countinversions;

import java.util.Arrays;
import java.util.Scanner;

public class Solution {
  private static int inversionCount = 0;

  private static final Scanner scanner = new Scanner(System.in);

  public static void main(String[] args) {
    int t = scanner.nextInt();
    scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

    for (int tItr = 0; tItr < t; tItr++) {
      int n = scanner.nextInt();
      scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

      int[] arr = new int[n];

      String[] arrItems = scanner.nextLine().split(" ");
      scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

      for (int i = 0; i < n; i++) {
        int arrItem = Integer.parseInt(arrItems[i]);
        arr[i] = arrItem;
      }

      long result = countInversionAlternative(arr);

      System.out.println(String.valueOf(result));
    }

    scanner.close();
  }

  static int countInversions(int[] input) {
    inversionCount = 0;
    mergeSort(input);
    return inversionCount;
  }

  static int countInversionAlternative(int[] input) {
    int inversionCount = 0;

    for (int i = 0; i < input.length - 1; i++) {
      for (int j = i + 1; j < input.length; j++) {
        if (input[i] > input[j]) {
          inversionCount++;
        }
      }
    }

    return inversionCount;
  }

  private static int[] mergeSort(int[] input) {
    if (input.length <= 1) {
      return input;
    }

    final int midPoint = input.length / 2;

    final int[] left = mergeSort(Arrays.copyOfRange(input, 0, midPoint));
    final int[] right = mergeSort(Arrays.copyOfRange(input, midPoint, input.length));

    return merge(left, right, midPoint);
  }

  private static int[] merge(int[] left, int[] right, int midPoint) {
    final int combinedLength = left.length + right.length;
    int[] merged = new int[combinedLength];
    int leftIndex = 0;
    int rightIndex = 0;

    for (int i = 0; i < combinedLength; i++) {
      boolean bothAreInRange = leftIndex < left.length && rightIndex < right.length;

      if (bothAreInRange) {
        if (left[leftIndex] <= right[rightIndex]) {
          merged[i] = left[leftIndex];
          leftIndex++;
        } else {
          merged[i] = right[rightIndex];
          rightIndex++;
          inversionCount += (midPoint - leftIndex);
        }
      } else if (leftIndex < left.length) {
        merged[i] = left[leftIndex];
        leftIndex++;
      } else {
        merged[i] = right[rightIndex];
        rightIndex++;
      }
    }

    return merged;
  }
}
