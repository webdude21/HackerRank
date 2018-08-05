package algorithms.countinversions;

import java.util.Arrays;

public class Solution {
  private static int inversionCount = 0;

  static int countInversion(int[] input) {
    final int[] merged = mergeSort(input);
    System.out.println(Arrays.toString(merged));

    return inversionCount;
  }

  private static int[] mergeSort(int[] input) {
    if (input.length <= 1) {
      return input;
    }

    final int midPoint = input.length / 2;

    final int[] left = mergeSort(Arrays.copyOfRange(input, 0, midPoint));
    final int[] right = mergeSort(Arrays.copyOfRange(input, midPoint, input.length));

    return merge(left, right);
  }

  private static int[] merge(int[] left, int[] right) {
    final int combinedLength = left.length + right.length;
    int[] merged = new int[combinedLength];
    int leftIndex = 0;
    int rightIndex = 0;

    for (int i = 0; i < combinedLength; i++) {
      boolean bothAreInRange = leftIndex < left.length && rightIndex < right.length;

      if (bothAreInRange) {
        if (left[leftIndex] < right[rightIndex]) {
          merged[i] = left[leftIndex];
          leftIndex++;
        } else {
          merged[i] = right[rightIndex];
          rightIndex++;
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
