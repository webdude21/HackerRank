package algorithms.markandtoys;

import java.util.Arrays;
import java.util.Scanner;

public class Solution {

  private static final Scanner scanner = new Scanner(System.in);

  public static void main(String[] args) {

    String[] nk = scanner.nextLine().split(" ");

    int n = Integer.parseInt(nk[0]);

    int k = Integer.parseInt(nk[1]);

    int[] prices = new int[n];

    String[] pricesItems = scanner.nextLine().split(" ");
    scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

    for (int i = 0; i < n; i++) {
      int pricesItem = Integer.parseInt(pricesItems[i]);
      prices[i] = pricesItem;
    }

    int result = maximumToys(prices, k);

    System.out.println(result);

    scanner.close();
  }

  static int maximumToys(int[] prices, int availableMoney) {
    Arrays.sort(prices);

    int currentSum = 0;

    for (int i = 0; i < prices.length; i++) {
      int currentPrice = prices[i];
      if (currentSum > availableMoney) {
        return i - 1;
      }

      currentSum += currentPrice;
    }

    return prices.length - 1;
  }
}
