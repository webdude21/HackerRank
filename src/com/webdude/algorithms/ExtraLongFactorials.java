package com.webdude.algorithms;

import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class ExtraLongFactorials {

    private static Map<BigInteger, BigInteger> calculated = new HashMap<>();

    private static BigInteger one = BigInteger.valueOf(1);

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        BigInteger n = in.nextBigInteger();

        System.out.println(calcFactorial(n));
    }

    public static BigInteger calcFactorial(BigInteger input){
        if (input.equals(one)){
            return one;
        }

        if (!calculated.containsKey(input)){
            calculated.put(input, input.multiply(calcFactorial(input.subtract(one))));
        }

        return calculated.get(input);
    }
}
