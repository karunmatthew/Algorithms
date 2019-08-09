package org.km.algorithms.dynamicProgramming;

public class Knapsack {

	public static void main(String[] args) {

		int w[] = { 0, 3, 2, 3, 4, 5, 6 };
		int v[] = { 0, 20, 15, 25, 30, 30, 50 };
		int n = 12; // max capacity

		int m[][] = new int[w.length][n + 1];

		int currentWeight;

		for (int i = 1; i < w.length; i++) {
			currentWeight = w[i];
			for (int j = 1; j <= n; j++) {

				if (j - currentWeight >= 0) {
					m[i][j] = Math.max(v[i] + m[i - 1][j - currentWeight], m[i - 1][j]);
				} else {
					m[i][j] = m[i - 1][j];
				}

			}
		}

		for (int i = 0; i < w.length; i++) {
			for (int j = 0; j <= n; j++) {
				System.out.printf("%2d ", m[i][j]);
			}
			System.out.println();
		}

	}
}
