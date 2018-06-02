package algorithms.encryption;

import java.util.Scanner;

class Solution {

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    String input = scanner.next();
    int l = input.length();
    double squareRootOfL = Math.sqrt(l);
    int columns = (int) Math.ceil(squareRootOfL);

    StringBuilder stringBuilder = new StringBuilder();

    for (int col = 0; col < columns; col++) {
      for (int i = col; i < l; i += columns) {
        stringBuilder.append(input.charAt(i));
      }
      stringBuilder.append(" ");
    }

    System.out.println(stringBuilder.toString());
  }
}
