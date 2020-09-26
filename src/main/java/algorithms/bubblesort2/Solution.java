package algorithms.bubblesort2;

import java.util.Objects;
import java.util.Scanner;

class Solution {
  private static final Scanner scanner = new Scanner(System.in);

  static BubbleSortResult bubbleSort(int[] input) {
    int swaps = 0;

    for (int i = 0; i < input.length; i++) {
      for (int j = i; j < input.length; j++) {
        if (input[j] < input[i]) {
          swap(input, i, j);
          swaps++;
        }
      }
    }

    return BubbleSortResult.of(swaps, input[0], input[input.length - 1]);
  }

  public static void main(String[] args) {
    int n = scanner.nextInt();
    scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

    int[] a = new int[n];

    String[] aItems = scanner.nextLine().split(" ");
    scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

    for (int i = 0; i < n; i++) {
      int aItem = Integer.parseInt(aItems[i]);
      a[i] = aItem;
    }

    System.out.println(bubbleSort(a));

    scanner.close();
  }

  private static void swap(int[] input, int i, int j) {
    int temp = input[i];
    input[i] = input[j];
    input[j] = temp;
  }

  static class BubbleSortResult {
    private final int swaps;
    private final int firstElement;
    private final int lastElement;

    private BubbleSortResult(int swaps, int firstElement, int lastElement) {
      this.swaps = swaps;
      this.firstElement = firstElement;
      this.lastElement = lastElement;
    }

    public static BubbleSortResult of(int swaps, int firstElement, int lastElement) {
      return new BubbleSortResult(swaps, firstElement, lastElement);
    }

    @Override
    public boolean equals(Object o) {
      if (this == o) return true;
      if (!(o instanceof BubbleSortResult)) return false;
      BubbleSortResult that = (BubbleSortResult) o;
      return getSwaps() == that.getSwaps() &&
        getFirstElement() == that.getFirstElement() &&
        getLastElement() == that.getLastElement();
    }

    @Override
    public String toString() {
      return String.format(
        "Array is sorted in %d swaps.%n" +
          "First Element: %d%n" +
          "Last Element: %d", swaps, firstElement, lastElement);
    }

    @Override
    public int hashCode() {
      return Objects.hash(getSwaps(), getFirstElement(), getLastElement());
    }

    int getSwaps() {
      return swaps;
    }

    int getFirstElement() {
      return firstElement;
    }

    int getLastElement() {
      return lastElement;
    }
  }
}
