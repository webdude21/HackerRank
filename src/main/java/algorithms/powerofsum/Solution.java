package algorithms.powerofsum;

import java.util.Scanner;

class Solution {

  private static final Scanner scanner = new Scanner(System.in);

  private static int power;

  private static int target;

  public static void main(String[] args) {
    target = scanner.nextInt();
    power = scanner.nextInt();

    int result = powerSum(1, 0);
    System.out.println(result);
  }

  private static int powerSum(int base, int sum) {
    int cur = (int) Math.pow(base, power);
    int candidateTarget = sum + cur;

    if (candidateTarget == target) {
      return 1;
    }

    if (sum > target || cur > target) {
      return 0;
    }

    return powerSum(base + 1, candidateTarget) + powerSum(base + 1, sum);
  }
}
