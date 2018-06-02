package algorithms.bubblesort;

import java.util.Scanner;

class Solution {

  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    int n = in.nextInt();
    int arrayToSort[] = new int[n];

    for (int i = 0; i < n; i++) {
      arrayToSort[i] = in.nextInt();
    }

    bubbleSort(arrayToSort, arrayToSort.length);
  }

  private static void bubbleSort(int[] arrayToSort, int n) {
    int totalSwaps = 0;

    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n - 1; j++) {
        if (arrayToSort[j] > arrayToSort[j + 1]) {
          swap(arrayToSort, j, j + 1);
          totalSwaps++;
        }
      }
    }

    printResult(arrayToSort, totalSwaps);
  }

  private static void printResult(int[] arrayToSort, int totalSwaps) {
    System.out.printf("Array is sorted in %d swaps.%n", totalSwaps);
    System.out.printf("First Element: %d%n", arrayToSort[0]);
    System.out.printf("Last Element: %d%n", arrayToSort[arrayToSort.length - 1]);
  }

  private static void swap(int[] array, int a, int b) {
    int swap = array[a];
    array[a] = array[b];
    array[b] = swap;
  }
}
