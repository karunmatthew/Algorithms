package org.km.algorithms;

public class Test {

	private static double t = 0;

	public static void main(String[] args) {

		System.out.println(doIt(2000));

	}

	private static double doIt(double n) {
		if (n < 1)
			return 1;
		for (double i = 0; i < n; i++) {
			for (double j = i; j < n; j++) {
				t++;
			}

		}
		return t + doIt(n - 1);
	}

}
