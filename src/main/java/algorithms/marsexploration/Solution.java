package algorithms.marsexploration;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Solution {

  private static final Scanner scanner = new Scanner(System.in);

  private static final String SOS = "SOS";

  static int marsExploration(String input) {
    int result = 0;

    for (int i = 0; i < input.length(); i += 3) {
      for (int j = 0; j < SOS.length(); j++) {
        if (input.charAt(i + j) != SOS.charAt(j)) {
          result++;
        }
      }
    }

    return result;
  }

  public static void main(String[] args) throws IOException {
    BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

    String s = scanner.nextLine();

    int result = marsExploration(s);

    bufferedWriter.write(String.valueOf(result));
    bufferedWriter.newLine();

    bufferedWriter.close();

    scanner.close();
  }
}
