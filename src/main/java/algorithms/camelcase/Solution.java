package algorithms.camelcase;

import java.util.Scanner;

class Solution {

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    System.out.println(countWords(scanner.nextLine()));
  }

  private static long countWords(String input) {
    return input
      .chars()
      .filter(Character::isUpperCase)
      .count() + 1;
  }
}
