package algorithms.twostrings;

import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;

public class Solution {

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    int testCases = scanner.nextInt();
    scanner.nextLine();

    for (int i = 0; i < testCases; i++) {
      boolean isSubString = isSubString(scanner.nextLine(), scanner.nextLine());
      System.out.println(isSubString ? "YES" : "NO");
    }
  }

  static boolean isSubString(String s1, String s2) {
    Set<Integer> chars = s2.chars().boxed().collect(Collectors.toSet());

    return s1.chars()
      .anyMatch(chars::contains);
  }
}
