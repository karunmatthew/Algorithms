package org.km.algorithms;

public class PolynomialRepresentation {

	public static void main(String[] args) {

		double n = 100000000;
		double A[] = new double[(int)n];

		for (int i = 0; i < n; i++) {
			A[i] = Math.random();
		}

		double x = 1;
		double x_val = 1;
		double sum = 0;
		int times = 0;
		for (int count = 0; count < n; count++) {
			sum = sum + x_val * A[count];
			x_val = x_val * x;
		}
		
		System.out.println(sum);

	}

}
