package algorithms.countingsorttwo;

import java.util.Scanner;

class Solution {

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    int digitCount = scanner.nextInt();
    int[] countResult = new int[100];

    for (int i = 0; i < digitCount; i++) {
      countResult[scanner.nextInt()]++;
    }

    printArray(countResult);
  }

  private static void printArray(int[] array) {
    StringBuilder sb = new StringBuilder();

    for (int i = 0; i < array.length; i++) {
      for (int j = 0; j < array[i]; j++) {
        sb.append(i);
        sb.append(" ");
      }
    }

    System.out.println(sb.toString().trim());
  }
}
