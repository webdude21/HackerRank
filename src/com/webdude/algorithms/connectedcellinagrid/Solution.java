package com.webdude.algorithms.connectedcellinagrid;

import java.util.Scanner;

public class Solution {

    private static Scanner scanner;
    private static int[][] matrix;

    public static void main(String[] args) {
        matrix = readInput();
        solve();
        System.out.println(matrix);
    }

    private static void solve() {
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                matrix[row][col] = scanner.nextInt();
            }
        }

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
