package com.webdude.algorithms;

import java.math.BigInteger;
import java.util.Scanner;

public class ExtraLongFactorials {

    private static BigInteger one = BigInteger.valueOf(1);

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println(calcFactorial(in.nextBigInteger()));
    }

    public static BigInteger calcFactorial(BigInteger input) {
        if (input.equals(one)) {
            return one;
        }

        return input.multiply(calcFactorial(input.subtract(one)));
    }
}
