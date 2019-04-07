package org.km.test;

public class Exponent {
	public static void main(String[] args) {

		double a = 1.0000030045;
		int b = 10000000;

		System.out.println(System.currentTimeMillis());
		System.out.println(power(a, b));
		System.out.println(System.currentTimeMillis());
		System.out.println(powerNormal(a, b));
		System.out.println(System.currentTimeMillis());
		System.out.println(powerIterative(a, b));
		System.out.println(System.currentTimeMillis());

	}

	public static double powerNormal(double a, int b) {
		double product = 1;
		for (int i = 1; i <= b; i++) {
			product = product * a;
		}
		return product;
	}

	public static double power(double a, int b) {

		double temp = 0;
		if (b == 1) {
			return a;
		} else if (b % 2 == 0) {
			temp = power(a, b / 2);
			return temp * temp;
		} else if (b % 2 == 1) {
			temp = power(a, b / 2);
			return a * temp * temp;
		}
		return a;
	}

	public static double powerIterative(double x, int n) {
		// Exponentiation by multiplication
		double y = 1;

		while (n > 1) {
			 if (n % 2 == 1) {
				y = y * x;
				x = x * x;
				n = (n - 1) / 2;
			} else {
				x = x * x;
				n = n / 2;
			}
		}
		return x * y;
	}
}

