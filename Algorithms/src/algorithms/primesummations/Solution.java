package algorithms.primesummations;

import java.util.ArrayList;
import java.util.Scanner;

class Solution {

	private static final StringBuilder output = new StringBuilder();

	private static final ArrayList<Integer> primes = generatePrimes(2000);

	private static long combinationsFound = 0;

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int linesOfInput = scanner.nextInt();
		ArrayList<Integer> input = new ArrayList<>();

		for (int i = 0; i < linesOfInput; i++) {
			scanner.nextLine();
			input.add(scanner.nextInt());
		}

		input.forEach(Solution::printResult);
		System.out.print(output.toString());
	}

	private static ArrayList<Integer> generatePrimes(int max) {
		ArrayList<Integer> primes = new ArrayList<>();

		for (int primeCandidate = 2; primeCandidate <= max; primeCandidate++) {
			if (isPrime(primeCandidate)) {
				primes.add(primeCandidate);
			}
		}

		return primes;
	}

	private static void generateSumOfPrimesPermutation(int number, long currentSum, int startIndex, int primeLimit) {
		if (currentSum == number) {
			combinationsFound++;
			return;
		}

		if (currentSum > number) {
			return;
		}

		for (int i = startIndex; i < primeLimit; i++) {
			long nextSum = currentSum + primes.get(i);
			generateSumOfPrimesPermutation(number, nextSum, startIndex++, primeLimit);
		}
	}

	private static long possibleSumOfPrimes(int number) {
		combinationsFound = 0;
		int suitablePrimes = 0;

		for (Integer prime : primes) {
			int possiblePrimes = prime;
			if (possiblePrimes > number) {
				break;
			} else {
				suitablePrimes++;
			}
		}

		generateSumOfPrimesPermutation(number, 0, 0, suitablePrimes);
		return combinationsFound;
	}

	private static void printResult(int number) {
		output.append(possibleSumOfPrimes(number));
		output.append(System.lineSeparator());
	}

	private static boolean isPrime(int primeCandidate) {
		for (int i = 2; i <= Math.sqrt(primeCandidate); i++) {
			if (primeCandidate % i == 0) {
				return false;
			}
		}
		return true;
	}
}
