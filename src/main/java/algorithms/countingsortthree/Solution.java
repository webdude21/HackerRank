package algorithms.countingsortthree;

import java.util.Scanner;

class Solution {

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int n = scanner.nextInt();

    int[] numberCount = new int[100];

    for (int i = 0; i <= n; i++) {
      String[] words = scanner.nextLine().split(" ");
      if (!words[0].equals("")) {
        int number = Integer.parseInt(words[0]);
        numberCount[number] += 1;
      }
    }

    int sum;

    for (int i = 0; i < numberCount.length; i++) {
      sum = 0;

      for (int j = 0; j <= i; j++) {
        sum += numberCount[j];
      }

      System.out.print(sum + " ");
    }
  }
}
