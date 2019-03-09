package algorithms.triplesum;

import java.util.HashSet;
import java.util.Objects;
import java.util.Scanner;
import java.util.Set;

public class Solution {

  private static final Scanner scanner = new Scanner(System.in);

  static long triplets(int[] a, int[] b, int[] c) {
    Set<Triplet> triplets = new HashSet<>();

    for (int aElement : a) {
      for (int bElement : b) {
        for (int cElement : c) {
          if (aElement <= bElement && bElement >= cElement) {
            triplets.add(Triplet.of(aElement, bElement, cElement));
          }
        }
      }
    }

    return triplets.size();
  }

  static class Triplet {
    private final int a;
    private final int b;
    private final int c;

    Triplet(int a, int b, int c) {
      this.a = a;
      this.b = b;
      this.c = c;
    }

    static Triplet of(int a, int b, int c) {
      return new Triplet(a, b, c);
    }

    @Override
    public boolean equals(Object o) {
      if (this == o) return true;
      if (!(o instanceof Triplet)) return false;
      Triplet triplet = (Triplet) o;
      return a == triplet.a && b == triplet.b && c == triplet.c;
    }

    @Override
    public int hashCode() {
      return Objects.hash(a, b, c);
    }

    @Override
    public String toString() {
      return "Triplet{" +
        "a=" + a +
        ", b=" + b +
        ", c=" + c +
        '}';
    }
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
