package algorithms.triplesum;

import java.util.Arrays;
import java.util.Scanner;

public class Solution {

  private static final Scanner scanner = new Scanner(System.in);

  static long triplets(int[] a, int[] b, int[] c) {
    a = Arrays.stream(a).sorted().distinct().toArray();
    b = Arrays.stream(b).sorted().distinct().toArray();
    c = Arrays.stream(c).sorted().distinct().toArray();

    int j = 0, k = 0;
    long solutions = 0;

    for (int i : b) {
      while (j < a.length && a[j] <= i) {
        j++;
      }
      while (k < c.length && c[k] <= i) {
        k++;
      }
      solutions += (long) j * k;
    }

    return solutions;
  }

  public static void main(String[] args) {
    String[] lenaLenbLenc = scanner.nextLine().split(" ");
    int lena = Integer.parseInt(lenaLenbLenc[0]);
    int lenb = Integer.parseInt(lenaLenbLenc[1]);
    int lenc = Integer.parseInt(lenaLenbLenc[2]);

    int[] arra = new int[lena];

    String[] arraItems = scanner.nextLine().split(" ");
    scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

    for (int i = 0; i < lena; i++) {
      int arraItem = Integer.parseInt(arraItems[i]);
      arra[i] = arraItem;
    }

    int[] arrb = new int[lenb];

    String[] arrbItems = scanner.nextLine().split(" ");
    scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

    for (int i = 0; i < lenb; i++) {
      int arrbItem = Integer.parseInt(arrbItems[i]);
      arrb[i] = arrbItem;
    }

    int[] arrc = new int[lenc];

    String[] arrcItems = scanner.nextLine().split(" ");
    scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

    for (int i = 0; i < lenc; i++) {
      int arrcItem = Integer.parseInt(arrcItems[i]);
      arrc[i] = arrcItem;
    }

    long ans = triplets(arra, arrb, arrc);

    System.out.println(ans);

    scanner.close();
  }
}
