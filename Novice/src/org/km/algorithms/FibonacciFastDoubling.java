package org.km.algorithms;

import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class FibonacciFastDoubling {

	private static Map<Double, Double> fibMap = new HashMap<>();

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();

		fibMap.put(0d, 0d);
		fibMap.put(1d, 1d);
		fibMap.put(2d, 1d);

		System.out.println(System.currentTimeMillis());
		System.out.println(fib(n));
		System.out.println(System.currentTimeMillis());
		// System.out.println(recFib(n));
		System.out.println(System.currentTimeMillis());
		System.out.println(itrFib(n));
		System.out.println(System.currentTimeMillis());
		System.out.println(fastFibonacciDoubling(n));
		System.out.println(System.currentTimeMillis());

		scanner.close();
	}

	private static double fib(int n) {

		//System.out.println("Calculating fib ----- " + n);
		double nFib, n1Fib;
		if (fibMap.get((double) n) != null) {
			return fibMap.get((double) n);
		}

		nFib = fib((int) (n / 2));
		fibMap.put((double) ((int) (n / 2)), nFib);

		n1Fib = fib((int) (n / 2) + 1);
		fibMap.put((double) ((int) (n / 2) + 1), n1Fib);

		if (n % 2 == 1) {
			return nFib * nFib + n1Fib * n1Fib;
		} else {
			return nFib * (2 * n1Fib - nFib);
		}
	}

	private static double recFib(int n) {

		if (n == 0) {
			return 0;

		} else if (n == 1) {
			return 1;
		} else {
			return recFib(n - 1) + recFib(n - 2);
		}
	}

	private static double itrFib(int n) {

		double a = 0;
		double b = 1;
		double c = 0;

		if (n == 0) {
			return 0;
		} else if (n == 1) {
			return 1;
		} else {
			while (n > 1) {
				c = a + b;
				a = b;
				b = c;
				n--;
			}
			return c;
		}

	}

	private static BigInteger fastFibonacciDoubling(int n) {
		BigInteger a = BigInteger.ZERO;
		BigInteger b = BigInteger.ONE;
		int m = 0;
		for (int bit = Integer.highestOneBit(n); bit != 0; bit >>>= 1) {

			// Double it
			BigInteger d = multiply(a, b.shiftLeft(1).subtract(a));
			BigInteger e = multiply(a, a).add(multiply(b, b));
			a = d;
			b = e;
			m *= 2;

			// Advance by one conditionally
			if ((n & bit) != 0) {
				BigInteger c = a.add(b);
				a = b;
				b = c;
				m++;

			}
		}
		return a;
	}

	private static BigInteger multiply(BigInteger x, BigInteger y) {
		return x.multiply(y);
	}

}
