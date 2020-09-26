package algorithms.specialpalindromeagain;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class Solution {

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    scanner.nextLine();
    String input = scanner.nextLine();

    System.out.println(solveAlternative(input));
  }

  static int solve(String input) {
    int palindromeSubstringCount = input.length();

    for (int i = 0; i < input.length(); i++) {
      for (int j = i + 1; j < input.length(); j++) {
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

  static int solveAlternative(String input) {
    final List<Pair> pairs = tokenizeString(input);
    final int pairCount = pairs.size();
    Pair lastPair = pairs.get(0);

    int result = sum(lastPair.count);

    for (int i = 1; i < pairCount; i++) {
      final Pair currentPair = pairs.get(i);
      result += sum(currentPair.count);

      if (currentPair.count == 1 && i < pairCount - 1) {
        final Pair nextPair = pairs.get(i + 1);
        if (lastPair.letter == nextPair.letter) {
          result += Math.min(lastPair.count, nextPair.count);
        }
      }

      lastPair = currentPair;
    }

    return result;
  }

  private static int sum(int n) {
    return (n * (n + 1)) / 2;
  }

  static List<Pair> tokenizeString(String input) {
    List<Pair> pairList = new ArrayList<>();

    Pair lastChar = Pair.of(input.charAt(0), 1);

    pairList.add(lastChar);

    for (int i = 1; i < input.length(); i++) {
      final char currentChar = input.charAt(i);
      if (lastChar.letter == currentChar) {
        lastChar.count++;
      } else {
        lastChar = Pair.of(currentChar, 1);
        pairList.add(lastChar);
      }
    }

    return pairList;
  }

  static class Pair {
    private final char letter;
    private int count;

    Pair(char letter, int count) {
      this.letter = letter;
      this.count = count;
    }

    static Pair of(char letter, int count) {
      return new Pair(letter, count);
    }

    @Override
    public boolean equals(Object o) {
      if (this == o) return true;
      if (!(o instanceof Pair)) return false;
      Pair pair = (Pair) o;
      return letter == pair.letter &&
        count == pair.count;
    }

    @Override
    public int hashCode() {
      return Objects.hash(letter, count);
    }
  }
}
