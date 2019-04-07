package org.km.test;

public class MatrixMultiplication {

	public static void main(String[] args) {

		int A[][] = new int[][] { { 1, 0, 0 }, { 0, 1, 0 }, { 0, 0, 1 } };
		int B[][] = new int[][] { { 3, 2, 1 }, { 7, 6, 5 }, { 9, 9, 0 } };

		multiply(A, B);
	}

	public static void multiply(int[][] A, int[][] B) {

		int C[][] = new int[A.length][B[0].length];

		for (int i = 0; i < A.length; i++) {

			for (int j = 0; j < B[0].length; j++) {

				for (int k = 0; k < A.length; k++) {

					C[i][j] = C[i][j] + A[i][k] * B[k][j];
				}
			}
		}

		for (int i = 0; i < C.length; i++) {
			for (int j = 0; j < C[0].length; j++) {
				System.out.print(C[i][j] + " \t");
			}
			System.out.println("\n");
		}

	}
}
