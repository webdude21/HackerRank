package algorithms.luckbalance;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;
import java.util.function.Predicate;
import java.util.function.ToIntFunction;

public class Solution {

  private static final Scanner scanner = new Scanner(System.in);

  public static void main(String[] args) {

    String[] nk = scanner.nextLine().split(" ");

    int n = Integer.parseInt(nk[0]);

    int k = Integer.parseInt(nk[1]);

    int[][] contests = new int[n][2];

    for (int i = 0; i < n; i++) {
      String[] contestsRowItems = scanner.nextLine().split(" ");
      scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

      for (int j = 0; j < 2; j++) {
        int contestsItem = Integer.parseInt(contestsRowItems[j]);
        contests[i][j] = contestsItem;
      }
    }

    System.out.println(luckBalance(k, contests));

    scanner.close();
  }

  static int luckBalance(int maxImportantContestsToLose, int[][] contests) {
    final Predicate<int[]> important = ints -> ints[1] == 1;
    final ToIntFunction<int[]> extractLuckValue = value -> value[0];

    final int sumOfNonImportant = Arrays.stream(contests)
      .filter(important.negate())
      .mapToInt(extractLuckValue)
      .sum();

    final int importantThatCanBeLost = Arrays.stream(contests)
      .filter(important)
      .mapToInt(extractLuckValue)
      .boxed()
      .sorted(Comparator.reverseOrder())
      .limit(maxImportantContestsToLose)
      .mapToInt(Integer::intValue)
      .sum();

    final int importantThatHaveToBeWan = Arrays.stream(contests)
      .filter(important)
      .mapToInt(extractLuckValue)
      .boxed()
      .sorted(Comparator.reverseOrder())
      .skip(maxImportantContestsToLose)
      .mapToInt(Integer::intValue)
      .sum();

    return sumOfNonImportant + importantThatCanBeLost - importantThatHaveToBeWan;
  }
}
