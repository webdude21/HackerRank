package algorithms.minimumswaps2;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Solution {
  private static final Scanner scanner = new Scanner(System.in);

  public static void main(String[] args) throws IOException {
    BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

    int n = scanner.nextInt();
    scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

    int[] arr = new int[n];

    String[] arrItems = scanner.nextLine().split(" ");
    scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

    for (int i = 0; i < n; i++) {
      int arrItem = Integer.parseInt(arrItems[i]);
      arr[i] = arrItem;
    }

    int res = minimumSwaps(arr);

    bufferedWriter.write(String.valueOf(res));
    bufferedWriter.newLine();

    bufferedWriter.close();

    scanner.close();
  }

  static int minimumSwaps(int[] a) {
    int swap = 0;
    for (int i = 0; i < a.length - 1; i++) {
      if (i + 1 != a[i]) {
        int t = i;
        while (a[t] != i + 1) {
          t++;
        }
        int temp = a[t];
        a[t] = a[i];
        a[i] = temp;
        swap++;
      }
    }
    return swap;
  }
}
