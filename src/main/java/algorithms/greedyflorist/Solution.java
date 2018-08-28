package algorithms.greedyflorist;

import java.util.Arrays;
import java.util.Scanner;

public class Solution {

  private static final Scanner scanner = new Scanner(System.in);

  public static void main(String[] args) {
    String[] nk = scanner.nextLine().split(" ");

    int n = Integer.parseInt(nk[0]);

    int k = Integer.parseInt(nk[1]);

    int[] c = new int[n];

    String[] cItems = scanner.nextLine().split(" ");
    scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

    for (int i = 0; i < n; i++) {
      int cItem = Integer.parseInt(cItems[i]);
      c[i] = cItem;
    }

    System.out.println(getMinimumCost(k, c));

    scanner.close();
  }

  static int getMinimumCost(int friendsCount, int[] flowersPrice) {
    Arrays.sort(flowersPrice);

    final int flowersCount = flowersPrice.length;
    final int flowerPrices = Arrays.stream(flowersPrice).sum();
    final int flowersExtra = flowersCount % friendsCount;
    final int extraPrice = Arrays.stream(flowersPrice).limit(flowersExtra).sum();

    return flowerPrices + extraPrice;
  }
}
