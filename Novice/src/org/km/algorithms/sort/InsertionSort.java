package org.km.algorithms.sort;

public class InsertionSort {

	public static void main(String[] args) {

		int A[] = { 3, 2, 0, 1, 9, 6, 7, 4, 6, 2, 0 };

		int v = 0;
		
		for (int i = 1; i < A.length; i++) {
			v = A[i];
			int j = i;
			while (j > 0 && v < A[j - 1]) {
				A[j] = A[j - 1];
				j--;
			}
			A[j] = v;
		}

		for (int i = 0; i < A.length; i++) {
			System.out.print(A[i] + "  ");
		}
	}
}
