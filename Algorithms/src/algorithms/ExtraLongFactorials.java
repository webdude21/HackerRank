package algorithms;

import java.math.BigInteger;
import java.util.Scanner;

public class ExtraLongFactorials {

    private static BigInteger one = BigInteger.valueOf(1);

    private static Scanner scanner;

    public static BigInteger calcFactorial(BigInteger input) {
        if (input.equals(one)) {
            return one;
        }

        return input.multiply(calcFactorial(input.subtract(one)));
    }

    public static void main(String[] args) {
        scanner = new Scanner(System.in);
        System.out.println(calcFactorial(scanner.nextBigInteger()));
    }
}