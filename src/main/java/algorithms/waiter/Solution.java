package algorithms.waiter;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Solution {

  private static final Scanner scanner = new Scanner(System.in);

  static int[] waiter(int[] numbers, int q) {
    List<Integer> pile = Arrays.stream(numbers).boxed().collect(Collectors.toList());
    List<Integer> answers = new ArrayList<>();
    long currentPrime = 0L;

    for (int i = 0; i < q; i++) {
      currentPrime = nextPrimeFrom(currentPrime);
      List<Integer> aPile = new ArrayList<>();
      List<Integer> bPile = new ArrayList<>();
      for (int j = pile.size() - 1; j >= 0; j--) {
        Integer currentNumber = pile.get(j);
        if (currentNumber % currentPrime == 0) {
          bPile.add(currentNumber);
        } else {
          aPile.add(currentNumber);
        }
      }

      for (int bi = bPile.size() - 1; bi >= 0; bi--) {
        answers.add(bPile.get(bi));
      }

      pile = aPile;
    }


    for (int i = pile.size() - 1; i >= 0; i--) {
      answers.add(pile.get(i));
    }

    return answers.stream().mapToInt(Integer::intValue).toArray();
  }

  private static long nextPrimeFrom(Long from) {
    return BigInteger.valueOf(from).nextProbablePrime().longValue();
  }

  public static void main(String[] args) throws IOException {
    BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

    String[] nq = scanner.nextLine().split(" ");

    int n = Integer.parseInt(nq[0].trim());

    int q = Integer.parseInt(nq[1].trim());

    int[] number = new int[n];

    String[] numberItems = scanner.nextLine().split(" ");

    for (int numberItr = 0; numberItr < n; numberItr++) {
      int numberItem = Integer.parseInt(numberItems[numberItr].trim());
      number[numberItr] = numberItem;
    }

    int[] result = waiter(number, q);

    for (int resultItr = 0; resultItr < result.length; resultItr++) {
      bufferedWriter.write(String.valueOf(result[resultItr]));

      if (resultItr != result.length - 1) {
        bufferedWriter.write("\n");
      }
    }

    bufferedWriter.newLine();

    bufferedWriter.close();
  }
}
