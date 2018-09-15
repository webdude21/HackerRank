package algorithms.sequenceequation;

import java.util.Arrays;
import java.util.Scanner;

public class Solution {

  private static final Scanner scanner = new Scanner(System.in);

  public static void main(String[] args) {
    int n = scanner.nextInt();
    scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

    int[] p = new int[n];

    String[] pItems = scanner.nextLine().split(" ");
    scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

    for (int i = 0; i < n; i++) {
      int pItem = Integer.parseInt(pItems[i]);
      p[i] = pItem;
    }

    int[] result = permutationEquation(p);

    Arrays.stream(result).forEach(System.out::println);

    scanner.close();
  }

  static int[] permutationEquation(int[] input) {
    int[] resultArr = new int[input.length];

    for (int element : input) {
      resultArr[input[input[element - 1] - 1] - 1] = element;
    }

    return resultArr;
  }
}
