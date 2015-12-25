package algorithms.connectedcellinagrid;

import java.util.Scanner;

public class Solution {

    private static Scanner scanner;
    private static int[][] matrix;
    private static int maxConnectedArea = 0;
    private static int currentConnectedArea = 0;

    public static void main(String[] args) {
        matrix = readInput();
        solve();
        if (currentConnectedArea > maxConnectedArea) {
            maxConnectedArea = currentConnectedArea;
        }
        System.out.println(maxConnectedArea);
    }

    private static void solve() {
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                if (matrix[row][col] > 0) {
                    if (currentConnectedArea > maxConnectedArea) {
                        maxConnectedArea = currentConnectedArea;
                    }
                    currentConnectedArea = 0;
                    tryPath(row, col);
                }
            }
        }
    }

    private static void tryPath(int row, int col) {
        if (!canMove(row, col)) {
            return;
        }

        currentConnectedArea++;
        matrix[row][col] = 0;

        // up
        tryPath(row + 1, col);
        // down
        tryPath(row - 1, col);
        // left
        tryPath(row, col - 1);
        // right
        tryPath(row, col + 1);
        // up-right
        tryPath(row - 1, col + 1);
        // down-right
        tryPath(row + 1, col + 1);
        // up-left
        tryPath(row - 1, col - 1);
        // down-left
        tryPath(row + 1, col - 1);
    }

    private static boolean canMove(int row, int col) {
        boolean isOutsideTheMatrix = row < 0 || row >= matrix.length || col >= matrix[row].length || col < 0;
        return !isOutsideTheMatrix && matrix[row][col] > 0;
    }

    private static void printMatrix() {
        for (int[] aMatrix : matrix) {
            for (int anAMatrix : aMatrix) {
                System.out.print(anAMatrix);
            }
            System.out.println();
        }

        System.out.println("--------");
        System.out.println(currentConnectedArea);
    }

    private static int[][] readInput() {
        scanner = new Scanner(System.in);
        int rows = scanner.nextInt();
        int cols = scanner.nextInt();
        int[][] matrix = new int[rows][cols];

        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                matrix[row][col] = scanner.nextInt();
            }
        }

        return matrix;
    }
}
