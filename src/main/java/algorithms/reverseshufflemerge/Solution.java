package algorithms.reverseshufflemerge;

import java.util.Scanner;

public class Solution {

  private static final Scanner scanner = new Scanner(System.in);

  public static void main(String[] args) {
    System.out.println(reverseShuffleMerge(scanner.nextLine()));
    scanner.close();
  }

  static String reverseShuffleMerge(String input) {
    final String left = input.substring(0, input.length() / 2);
    final String right = input.substring(input.length() / 2);


    return input;
  }
}
