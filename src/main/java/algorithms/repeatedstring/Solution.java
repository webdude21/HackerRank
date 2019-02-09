package algorithms.repeatedstring;

import java.util.Scanner;

public class Solution {

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    String input = scanner.nextLine();
    long repeatLength = scanner.nextLong();
    System.out.println(repeatedString(input, repeatLength));
  }

  static long repeatedString(String input, long length) {
    long aCount = input.chars().filter(ch -> ch == 'a').count();
    long repeatedTimes = length / input.length();
    long remainderCount = length % input.length();
    long remainderACount = input.chars().limit(remainderCount).filter(ch -> ch == 'a').count();
    return (aCount * repeatedTimes) + remainderACount;
  }
}
