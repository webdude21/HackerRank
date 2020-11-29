package algorithms.cipher;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Solution {

  private static final Scanner scanner = new Scanner(System.in);

  static String cipher(int k, String s) {
    char[] result = new char[s.length() - k + 1];
    result[0] = s.charAt(0);
    int i;
    for (i = 1; i < k; i++) {
      result[i] = reverseXor(s.charAt(i), s.charAt(i - 1));
    }
    for (; i < s.length() - k + 1; i++) {
      result[i] = s.charAt(i) == s.charAt(i - 1) ? result[i - k] : (reverseXor(result[i - k], '1'));
    }
    return new String(result);
  }

  private static char reverseXor(char c, char c2) {
    return c == c2 ? '0' : '1';
  }

  public static void main(String[] args) throws IOException {
    BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

    String[] nk = scanner.nextLine().split(" ");

    int n = Integer.parseInt(nk[0]);

    int k = Integer.parseInt(nk[1]);

    String s = scanner.nextLine();

    String result = cipher(k, s);

    bufferedWriter.write(result);
    bufferedWriter.newLine();

    bufferedWriter.close();

    scanner.close();
  }
}
