package algorithms.maximumsubarray;

import javafx.util.Pair;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Stream;

class Solution {

  private static Scanner scanner;

  public static void main(String[] args) {
    scanner = new Scanner(System.in);
    int testCasesCount = scanner.nextInt();
    Stream.iterate(1L, n -> n + 1)
      .limit(testCasesCount)
      .forEach(x -> printResult(solveTestCase()));
  }

  private static void printResult(Pair<Integer, Integer> pair) {
    System.out.printf("%d %d%n", pair.getKey(), pair.getValue());
  }

  private static Pair<Integer, Integer> solveTestCase() {
    int arrayLength = scanner.nextInt();
    int[] numbers = new int[arrayLength];

    for (int i = 0; i < arrayLength; i++) {
      numbers[i] = scanner.nextInt();
    }

    boolean allNegative = Arrays
      .stream(numbers)
      .allMatch(x -> x < 0);

    if (allNegative) {
      int maxNegative = Arrays
        .stream(numbers)
        .max()
        .orElse(-1);
      return new Pair<>(maxNegative, maxNegative);
    }

    return new Pair<>(maxSumForContiguousElements(numbers), maxSumForNonContiguousElements(numbers));
  }

  private static int maxSumForContiguousElements(int[] numbers) {
    int maxSumEndingHere = 0;
    int maxSumSoFar = 0;

    for (int number : numbers) {
      maxSumEndingHere = Math.max(0, maxSumEndingHere + number);
      maxSumSoFar = Math.max(maxSumSoFar, maxSumEndingHere);
    }

    return maxSumSoFar;
  }

  private static int maxSumForNonContiguousElements(int[] numbers) {
    return Arrays.stream(numbers).filter(x -> x > 0).sum();
  }
}
