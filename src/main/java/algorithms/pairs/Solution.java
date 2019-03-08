package algorithms.pairs;

import java.util.Arrays;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;

public class Solution {

  private static final Scanner scanner = new Scanner(System.in);

  static int pairsWithSet(int k, int[] arr) {
    int diffCount = 0;

    Set<Integer> set = Arrays.stream(arr).boxed().collect(Collectors.toSet());

    for (Integer number : set) {
      if (set.contains(number + k)) {
        diffCount++;
      }
    }

    return diffCount;
  }


  static int pairsWithSorting(int k, int[] arr) {
    int diffCount = 0;

    Arrays.sort(arr);

    for (int i = 0; i < arr.length; i++) {
      for (int j = i + 1; j < arr.length; j++) {
        if (arr[i] + k > arr[j]) {
          continue;
        }

        if (arr[i] + k == arr[j]) {
          diffCount++;
        }
      }
    }

    return diffCount;
  }

  static int pairsWithBinarySearch(int k, int[] arr) {
    int diffCount = 0;

    Arrays.sort(arr);

    for (int i = 0; i < arr.length; i++) {
      int currentNumber = arr[i];

      if (Arrays.binarySearch(arr, i, arr.length, currentNumber + k) > 0) {
        diffCount++;
      }
    }

    return diffCount;
  }

  public static void main(String[] args) {

    String[] nk = scanner.nextLine().split(" ");

    int n = Integer.parseInt(nk[0]);

    int k = Integer.parseInt(nk[1]);

    int[] arr = new int[n];

    String[] arrItems = scanner.nextLine().split(" ");
    scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

    for (int i = 0; i < n; i++) {
      int arrItem = Integer.parseInt(arrItems[i]);
      arr[i] = arrItem;
    }

    System.out.println(pairsWithBinarySearch(k, arr));

    scanner.close();
  }
}
