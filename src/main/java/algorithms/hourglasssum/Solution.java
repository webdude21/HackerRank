package algorithms.hourglasssum;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Solution {

  private static final Scanner scanner = new Scanner(System.in);

  private static final int[][] shapeOffsets = new int[][]{
    new int[]{2, 1, 0},
    new int[]{1},
    new int[]{2, 1, 0}
  };

  static int hourglassSum(int[][] input) {
    int maxSum = Integer.MIN_VALUE;

    for (int row = 2; row < input.length; row++) {
      for (int col = 2; col < input.length; col++) {
        maxSum = Math.max(maxSum, sumOffsets(row, col, input));
      }
    }

    return maxSum;
  }

  private static int sumOffsets(int row, int col, int[][] input) {
    int localSum = 0;

    for (int i = 0; i < shapeOffsets.length; i++) {
      for (int j = 0; j < shapeOffsets[i].length; j++) {
        final int colOffset = shapeOffsets[i][j];
        localSum += input[row - i][col - colOffset];
      }
    }

    return localSum;
  }


  public static void main(String[] args) throws IOException {
    BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

    int[][] arr = new int[6][6];

    for (int i = 0; i < 6; i++) {
      String[] arrRowItems = scanner.nextLine().split(" ");
      scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

      for (int j = 0; j < 6; j++) {
        int arrItem = Integer.parseInt(arrRowItems[j]);
        arr[i][j] = arrItem;
      }
    }

    int result = hourglassSum(arr);

    bufferedWriter.write(String.valueOf(result));
    bufferedWriter.newLine();

    bufferedWriter.close();

    scanner.close();
  }
}
