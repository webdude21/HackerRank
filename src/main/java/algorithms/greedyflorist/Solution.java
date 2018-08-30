package algorithms.greedyflorist;

import java.util.Arrays;
import java.util.Comparator;
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
    flowersPrice = Arrays.stream(flowersPrice)
      .boxed()
      .sorted(Comparator.reverseOrder())
      .mapToInt(Integer::valueOf)
      .toArray();

    int sum = 0;

    for (int i = 0; i < flowersPrice.length; i++) {
      sum += flowersPrice[i] * ((i / friendsCount) + 1);
    }

    return sum;
  }
}
