package algorithms.sockmerchant;

import java.util.Scanner;
import java.util.function.Function;
import java.util.stream.Stream;

import static java.util.stream.Collectors.counting;
import static java.util.stream.Collectors.groupingBy;

public class Solution {

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    scanner.nextLine();
    System.out.println(countSockPairs(scanner.nextLine()));
  }

  static long countSockPairs(String socks) {
    return Stream.of(socks.split("\\s+"))
      .collect(groupingBy(Function.identity(), counting()))
      .values()
      .stream()
      .mapToLong(Long::longValue)
      .map(x -> x / 2)
      .sum();
  }
}
