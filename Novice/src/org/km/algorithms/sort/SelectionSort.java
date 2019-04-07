package org.km.algorithms.sort;

public class SelectionSort {

	public static void main(String[] args) {
		int A[] = { 5, 7, 1, 4, 4, 0, 9, 3 };
		sort(A);
		for (int i = 0; i < A.length; i++) {
			System.out.print(A[i] + " ");
		}
	}

	public static void sort(int[] A) {
		int n = A.length;
		int min;
		int temp;
		for (int i = 0; i < n - 1; i++) {
			min = i;
			for (int j = i + 1; j < n; j++) {
				if (A[j] < A[min]) {
					min = j;
				}
			}
			temp = A[min];
			A[min] = A[i];
			A[i] = temp;
		}
	}
}
