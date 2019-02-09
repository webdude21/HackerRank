package algorithms.countingvalleys;

import java.util.Scanner;

public class Solution {

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    scanner.nextLine();
    System.out.println(countingValleys(scanner.nextLine()));
  }

  static int countingValleys(String input) {
    int level = 0;
    int valleyCount = 0;

    for (int i = 0; i < input.length(); i++) {
      int previousLevel = level;
      boolean isGoingUp = input.charAt(i) == 'U';

      level += (isGoingUp ? 1 : -1);

      if (level == 0 && previousLevel < 0) {
        valleyCount++;
      }
    }

    return valleyCount;
  }
}
