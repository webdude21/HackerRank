package algorithms.caesarcipher;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Solution {

  private static final Scanner scanner = new Scanner(System.in);

  private static final List<Character> alphabet = "abcdefghijklmnopqrstuvwxyz".chars()
    .mapToObj(i -> (char) i)
    .collect(Collectors.toList());

  public static String caesarCipher(String input, int k) {
    Map<Character, Character> encryptionMap = getEncryptionMap(k);

    StringBuilder sb = new StringBuilder();

    for (char ch : input.toCharArray()) {
      char lowercaseChar = Character.toLowerCase(ch);
      char mappedChar = encryptionMap.getOrDefault(lowercaseChar, lowercaseChar);
      sb.append(Character.isUpperCase(ch) ? Character.toUpperCase(mappedChar) : mappedChar);
    }

    return sb.toString();
  }

  private static Map<Character, Character> getEncryptionMap(int k) {
    List<Character> rotatedAlphabet = new ArrayList<>(alphabet);
    Collections.rotate(rotatedAlphabet, -k);
    return IntStream
      .range(0, alphabet.size())
      .boxed()
      .collect(Collectors.toMap(alphabet::get, rotatedAlphabet::get, (a, b) -> b));
  }

  public static void main(String[] args) throws IOException {
    BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

    int n = scanner.nextInt();
    scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

    String s = scanner.nextLine();

    int k = scanner.nextInt();
    scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

    String result = caesarCipher(s, k);

    bufferedWriter.write(result);
    bufferedWriter.newLine();

    bufferedWriter.close();

    scanner.close();
  }
}
