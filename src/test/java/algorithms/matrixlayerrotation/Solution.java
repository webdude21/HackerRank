package algorithms.matrixlayerrotation;

import java.util.Scanner;

public class Solution {

  private static final Scanner scanner = new Scanner(System.in);

  public static void main(String[] args) {
    String[] mnr = scanner.nextLine().split(" ");

    int m = Integer.parseInt(mnr[0]);
    int n = Integer.parseInt(mnr[1]);
    int r = Integer.parseInt(mnr[2]);

    int[][] matrix = new int[m][n];

    for (int i = 0; i < m; i++) {
      String[] matrixRowItems = scanner.nextLine().split(" ");
      scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

      for (int j = 0; j < n; j++) {
        int matrixItem = Integer.parseInt(matrixRowItems[j]);
        matrix[i][j] = matrixItem;
      }
    }

    int[][] resultMatrix = rotateMatrix(matrix, r, 0);
    printMatrix(resultMatrix);

    scanner.close();
  }

  private static void printMatrix(int[][] resultMatrix) {
    StringBuilder sb = new StringBuilder();

    for (int[] arrays : resultMatrix) {
      for (int array : arrays) {
        sb.append(array).append(" ");
      }
      sb.append(System.lineSeparator());
    }

    System.out.println(sb.toString());
  }

  static int[][] rotateMatrix(int[][] matrix, int rotations, int startRow) {
    return matrix;
  }
}
