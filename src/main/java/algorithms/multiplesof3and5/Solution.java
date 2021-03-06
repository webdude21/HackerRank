package algorithms.multiplesof3and5;

import java.util.Scanner;

class Solution {

  private static final StringBuilder stringBuilder = new StringBuilder();

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int linesOfInput = scanner.nextInt();
    String lineSeparator = System.lineSeparator();

    for (int i = 0; i < linesOfInput; i++) {
      scanner.nextLine();
      stringBuilder.append(sumOfMultiples(3, 5, scanner.nextInt()));
      stringBuilder.append(lineSeparator);
    }

    System.out.print(stringBuilder.toString());
  }

  private static long sumOfMultiples(int i, int j, int limit) {
    long s = --limit / i, t = limit / j, u = limit / (i * j);
    return (i * (s * (s + 1) / 2)) + (j * (t * (t + 1) / 2)) - ((i * j) * (u * (u + 1) / 2));
  }
}
