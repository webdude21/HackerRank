package algorithms.icecreamparlor;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Solution {

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

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
    CostPosition[] costPositionArray = new CostPosition[cost.length];

    for (int i = 0; i < cost.length; i++) {
      costPositionArray[i] = new CostPosition(cost[i], i);
    }

    Arrays.sort(costPositionArray);

    for (int i = 0; i < costPositionArray.length; i++) {
      CostPosition a = costPositionArray[i];
      if (a.cost >= money) {
        continue;
      }

      CostPosition b = new CostPosition(money - a.cost, -1);
      int bPosition = Arrays.binarySearch(costPositionArray, i, costPositionArray.length, b);

      if (bPosition <= 0) {
        continue;
      } else {
        if (costPositionArray[bPosition].position == a.position) {
          bPosition = Arrays.binarySearch(costPositionArray, bPosition + 1, costPositionArray.length, b);
        }
      }

      int[] result = {a.position + 1, costPositionArray[bPosition].position + 1};
      Arrays.sort(result);
      return result;
    }

    throw new IllegalArgumentException("Shouldn't really get here.");
  }

  static class CostPosition implements Comparable<CostPosition> {
    int cost;
    int position;

    CostPosition(int cost, int position) {
      this.cost = cost;
      this.position = position;
    }

    @Override
    public int compareTo(CostPosition o) {
      return Integer.compare(this.cost, o.cost);
    }
  }
}
