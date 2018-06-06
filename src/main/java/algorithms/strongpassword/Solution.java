package algorithms.strongpassword;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Predicate;

public class Solution {

  private static final String NUMBERS = "0123456789";
  private static final String LOWER_CASE = "abcdefghijklmnopqrstuvwxyz";
  private static final String UPPER_CASE = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
  private static final String SPECIAL_CHARACTERS = "!@#$%^&*()-+";

  private static final List<Predicate<String>> securePasswordPredicates = Arrays.asList(
    containsAny(NUMBERS),
    containsAny(LOWER_CASE),
    containsAny(UPPER_CASE),
    containsAny(SPECIAL_CHARACTERS)
  );

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    scanner.nextLine();
    String password = scanner.nextLine();
    System.out.println(minimumNumber(password));
  }

  private static Predicate<String> containsAny(String charSet) {
    return input -> input.chars().anyMatch(value -> charSet.contains(String.valueOf((char) value)));
  }

  private static int minimumNumber(String n) {
    int unmetCriteria = (int) securePasswordPredicates.stream()
      .filter(stringPredicate -> !stringPredicate.test(n))
      .count();

    return n.length() + unmetCriteria >= 6 ? unmetCriteria : 6 - n.length();
  }
}
