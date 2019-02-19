package algorithms.icecreamparlor;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Solution {

  private static final Scanner scanner = new Scanner(System.in);

  public static void main(String[] args) {
    int t = scanner.nextInt();
    scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

    for (int tItr = 0; tItr < t; tItr++) {
      int money = scanner.nextInt();
      scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

      int n = scanner.nextInt();
      scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

      int[] cost = new int[n];

      String[] costItems = scanner.nextLine().split(" ");
      scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

      for (int i = 0; i < n; i++) {
        int costItem = Integer.parseInt(costItems[i]);
        cost[i] = costItem;
      }

      String output = Arrays.stream(whatFlavors(cost, money))
        .mapToObj(String::valueOf)
        .collect(Collectors.joining(" "));
      System.out.println(output);
    }

    scanner.close();
  }

  static int[] whatFlavors(int[] cost, int money) {
    for (int i = 0; i < cost.length; i++) {
      if (cost[i] >= money) {
        continue;
      }

      for (int j = i + 1; j < cost.length; j++) {
        if (cost[i] + cost[j] == money) {
          return new int[]{i + 1, j + 1};
        }
      }
    }

    return new int[]{0, 0};
  }
}
