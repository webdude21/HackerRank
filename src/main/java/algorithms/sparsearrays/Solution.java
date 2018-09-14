package algorithms.sparsearrays;

import java.util.Arrays;
import java.util.Map;
import java.util.Scanner;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Solution {

  private static final Scanner scanner = new Scanner(System.in);

  public static void main(String[] args) {

    int stringsCount = scanner.nextInt();
    scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

    String[] strings = new String[stringsCount];

    for (int i = 0; i < stringsCount; i++) {
      String stringsItem = scanner.nextLine();
      strings[i] = stringsItem;
    }

    int queriesCount = scanner.nextInt();
    scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

    String[] queries = new String[queriesCount];

    for (int i = 0; i < queriesCount; i++) {
      String queriesItem = scanner.nextLine();
      queries[i] = queriesItem;
    }

    int[] res = matchingStrings(strings, queries);

    Arrays.stream(res).forEach(System.out::println);

    scanner.close();
  }

  static int[] matchingStrings(String[] strings, String[] queries) {
    final Map<String, Long> occurrenceMap = Arrays.stream(strings).collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

    int[] result = new int[queries.length];

    IntStream.range(0, queries.length).forEach(i -> {
      final Long value = occurrenceMap.get(queries[i]);
      result[i] = (value != null ? Math.toIntExact(value) : 0);
    });

    return result;
  }
}
