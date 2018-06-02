package algorithms.insertionsortpartone;

import java.util.Scanner;

class Solution {

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int[] array = new int[scanner.nextInt()];

    for (int i = 0; i < array.length; i++) {
      array[i] = scanner.nextInt();
    }

    int digitToSort = array[array.length - 1];

    for (int i = array.length - 1; i >= 0; i--) {
      if (i > 0 && digitToSort <= array[i - 1]) {
        array[i] = array[i - 1];
      } else {
        array[i] = digitToSort;
        printArray(array);
        break;
      }

      printArray(array);
    }
  }

  private static void printArray(int[] array) {
    StringBuilder sb = new StringBuilder();

    for (int anArray : array) {
      sb.append(anArray);
      sb.append(" ");
    }

    System.out.println(sb.toString().trim());
  }
}
