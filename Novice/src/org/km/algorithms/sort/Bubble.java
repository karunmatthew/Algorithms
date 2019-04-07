package org.km.algorithms.sort;

public class Bubble {

	public static void main(String[] args) {
		int A[] = { 5, 7, 1, 4, 4, 0, 9, 3 };
		sort(A);
		for (int i = 0; i < A.length; i++) {
			System.out.print(A[i] + " ");
		}
	}

	public static void sort(int[] A) {
		int n = A.length;
		int temp;
		for (int i = 0; i < n - 1; i++) {
			for (int j = 0; j < n - i - 1; j++) {
				if (A[j] > A[j + 1]) {
					temp = A[j + 1];
					A[j + 1] = A[j];
					A[j] = temp;
				}
			}
		}
	}
}
