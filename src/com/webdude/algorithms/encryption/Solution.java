package com.webdude.algorithms.encryption;

import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        String input = new Scanner(System.in).next();
        int l = input.length();
        double squareRootOfL = Math.sqrt(l);
        int floorL = (int) Math.floor(squareRootOfL) - 1;
        int columns = (int) Math.ceil(squareRootOfL) - 1;

        StringBuilder stringBuilder = new StringBuilder();

        for (int i = 0; i < input.length(); i++) {
            if (i % columns == 0 && i != 0) {
                stringBuilder.append(System.lineSeparator());
            }

            stringBuilder.append(input.charAt(i));
        }

        System.out.println(stringBuilder.toString());
    }
}
