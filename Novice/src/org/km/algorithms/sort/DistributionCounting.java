package org.km.algorithms.sort;

public class DistributionCounting {

	public static void main(String[] args) {

		int u = 14;
		int l = 10;
		int A[] = { 10, 10, 14, 10, 10, 14, 13, 10, 10, 13 };

		int D[] = new int[u - l + 1];

		for (int i = 0; i < u - l; i++) {
			D[i] = 0;
		}

		// calculate frequencies
		for (int i = 0; i < A.length; i++) {
			D[A[i] - l] = D[A[i] - l] + 1;
		}

		// calculate distribution
		for (int j = 1; j <= u - l; j++) {
			D[j] = D[j - 1] + D[j];
		}

		for (int i : D) {
			System.out.println(i);
		}

		int S[] = new int[A.length];

		for (int i = 0; i < A.length; i++) {
			S[D[A[i] - l] - 1 ] = A[i];
			D[A[i] - l] = D[A[i] - l] - 1;
		}

		for (int i = 0; i < A.length; i++) {
			System.out.print(S[i] + " ");
		}

	}
}
