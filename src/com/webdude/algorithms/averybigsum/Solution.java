package com.webdude.algorithms.averybigsum;

import java.util.Scanner;

public class Solution {

    private static Scanner scanner;

    public static void main(String[] args) {
        scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        long sum = 0;

        for (int i = 0; i < n; i++) {
            sum += scanner.nextLong();
        }

        System.out.println(sum);
    }
}