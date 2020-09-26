package algorithms.larrysarray;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Solution {

  private static final Scanner scanner = new Scanner(System.in);
  private static final int MAX_ROTATIONS = 3;

  static String larrysArray(int[] input) {
    for (int i = 2; i < input.length; i++) {

      for (int j = 0; j < MAX_ROTATIONS; j++) {
        if (!isAlreadyOrdered(i - 2, input)) {
          rotate(i - 2, input);
        }
      }

      if (isSorted(input)) {
        return "YES";
      }
    }

    return "NO";
  }

  private static void rotate(int startIndex, int[] array) {
    // 3, 1, 2 --> 1, 2, 3

    int oldA = array[startIndex];
    array[startIndex] = array[startIndex + 2]; /// 2 1 2
    array[startIndex + 2] = oldA;  // 2 1 3
    int oldb = array[startIndex + 1];
    array[startIndex + 1] = array[startIndex]; // 2 2 3
    array[startIndex] = oldb; // 1 2 3
  }

  private static boolean isAlreadyOrdered(int startIndex, int[] array) {
    return array[startIndex] < array[startIndex + 1] && array[startIndex] < array[startIndex + 2];
  }

  private static boolean isSorted(int[] input) {
    for (int i = 1; i < input.length; i++) {
      if (input[i - 1] > input[i]) {
        return false;
      }
    }

    return true;
  }

  public static void main(String[] args) throws IOException {
    BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

    int t = scanner.nextInt();
    scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

    for (int tItr = 0; tItr < t; tItr++) {
      int n = scanner.nextInt();
      scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

      int[] A = new int[n];

      String[] AItems = scanner.nextLine().split(" ");
      scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

      for (int i = 0; i < n; i++) {
        int AItem = Integer.parseInt(AItems[i]);
        A[i] = AItem;
      }

      String result = larrysArray(A);

      bufferedWriter.write(result);
      bufferedWriter.newLine();
    }

    bufferedWriter.close();

    scanner.close();
  }
}
