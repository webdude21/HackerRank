package algorithms.specialpalindromeagain;

import java.util.Scanner;

public class Solution {

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    scanner.nextLine();
    String input = scanner.nextLine();

    System.out.println(solve(input));
  }

  static int solve(String input) {
    int palindromeSubstringCount = input.length();

    for (int i = 0; i < input.length(); i++) {
      for (int j = i + 2; j < input.length(); j++) {
        if (isSpecialPalindrome(input, i, j)) {
          palindromeSubstringCount++;
        }
      }
    }

    return palindromeSubstringCount;
  }

  static boolean isSpecialPalindrome(String palindromeCandidate, int startIndex, int endIndex) {
    final int subStrLength = endIndex - startIndex + 1;
    final char mainChar = palindromeCandidate.charAt(startIndex);
    final int midPoint = subStrLength / 2;

    for (int i = 0; i < midPoint; i++) {
      if (palindromeCandidate.charAt(startIndex + i) != mainChar || palindromeCandidate.charAt(endIndex - i) != mainChar) {
        return false;
      }
    }

    return true;
  }
}
