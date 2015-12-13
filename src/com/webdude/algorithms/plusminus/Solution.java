package com.webdude.algorithms.plusminus;

import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        double[] results = new double[]{0, 0, 0};

        for (int i = 0; i < n; i++) {
            double currentNumber = in.nextDouble();

            if (currentNumber > 0) {
                results[0]++;
            } else if (currentNumber < 0) {
                results[1]++;
            } else {
                results[2]++;
            }
        }

        for (int i = 0; i < results.length; i++) {
            double result = 0;
            if (results[i] > 0) {
                result = results[i] / n;
            }
            System.out.println(result);
        }
    }
}