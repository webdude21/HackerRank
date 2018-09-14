package algorithms.leftrotation;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Solution {

  private static final Scanner scanner = new Scanner(System.in);

  public static void main(String[] args) {
    String[] nd = scanner.nextLine().split(" ");

    int n = Integer.parseInt(nd[0]);

    int rotations = Integer.parseInt(nd[1]);

    int[] a = new int[n];

    String[] aItems = scanner.nextLine().split(" ");
    scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

    for (int i = 0; i < n; i++) {
      a[i] = Integer.parseInt(aItems[i]);
    }

    final String result = Arrays.stream(rotateLeft(rotations, a))
      .boxed()
      .map(Object::toString)
      .collect(Collectors.joining(" "));

    System.out.println(result);
  }

  static int[] rotateLeft(int rotations, int[] input) {
    int offset = input.length - rotations;
    int[] result = new int[input.length];

    System.arraycopy(input, 0, result, offset, rotations);
    System.arraycopy(input, rotations, result, 0, offset);

    return result;
  }
}
