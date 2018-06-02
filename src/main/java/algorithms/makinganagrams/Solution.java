package algorithms.makinganagrams;

import java.util.Map;
import java.util.Scanner;
import java.util.function.Function;
import java.util.stream.Collectors;

class Solution {

  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    String a = in.next();
    String b = in.next();
    System.out.println(numberNeeded(a, b));
  }

  static long numberNeeded(String first, String second) {
    Map<Integer, Long> charMap = getCharacterMap(first);

    long count = 0;

    for (int c : second.toCharArray()) {
      if (!charMap.containsKey(c) || charMap.containsKey(c) && charMap.get(c) == 0) {
        count++;
      } else {
        if (charMap.containsKey(c) && charMap.get(c) > 0) {
          charMap.put(c, charMap.get(c) - 1);
        }
      }
    }

    return count + charMap.values().stream().mapToLong(value -> value).sum();
  }

  private static Map<Integer, Long> getCharacterMap(String value) {
    return value.chars().boxed().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
  }
}
