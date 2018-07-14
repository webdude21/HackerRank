package algorithms.commonchild;

import java.util.Scanner;

public class Solution {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    final String a = scanner.nextLine();
    final String b = scanner.nextLine();

    System.out.println(solve(a, b));
  }

  static int solve(String a, String b) {
    int[][] table = new int[a.length() + 1][b.length() + 1];

    for (int indexA = 0; indexA < a.length(); indexA++) {
      for (int indexB = 0; indexB < b.length(); indexB++) {
        if (a.charAt(indexA) == b.charAt(indexB)) {
          table[indexA + 1][indexB + 1] = table[indexA][indexB] + 1;
        } else {
          table[indexA + 1][indexB + 1] = Math.max(table[indexA + 1][indexB], table[indexA][indexB + 1]);
        }
      }
    }

    return table[a.length()][b.length()];
  }
}
