package algorithms.angryprofessor;

import java.util.Arrays;
import java.util.Scanner;

public class Solution {
  static String angryProfessor(int k, int[] a) {
    return Arrays.stream(a).filter(t -> t <= 0).count() < k ? "YES" : "NO";
  }

  public static void main(String[] args) {

    try (Scanner scanner = new Scanner(System.in)) {
      int t = scanner.nextInt();
      scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

      for (int tItr = 0; tItr < t; tItr++) {
        String[] nk = scanner.nextLine().split(" ");

        int n = Integer.parseInt(nk[0]);
        int k = Integer.parseInt(nk[1]);
        int[] a = new int[n];
        String[] aItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
          int aItem = Integer.parseInt(aItems[i]);
          a[i] = aItem;
        }
        System.out.println(angryProfessor(k, a));
      }
    }
  }
}
