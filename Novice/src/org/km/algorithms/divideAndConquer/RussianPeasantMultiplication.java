package org.km.algorithms.divideAndConquer;

public class RussianPeasantMultiplication {

	public static void main(String[] args) {

		int a = 12;
		int b = 13;

		System.out.println(multiply(a, b, 0));

	}

	public static int multiply(int a, int b, int carry) {
		if (a == 1) {
			return b + carry;
		} else if (a % 2 == 0) {
			return multiply(a / 2, b * 2, carry + 0);
		} else {
			return multiply((a - 1) / 2, b * 2, carry + b);
		}
	}

}
