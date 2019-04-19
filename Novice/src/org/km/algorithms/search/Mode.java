package org.km.algorithms.search;

public class Mode {

	// Find the mode in a list of numbers
	public static void main(String[] args) {

		int A[] = { 6, 2, 3, 3, 2, 3, 3, 4, 3, 3, 9, 3, 2 };
		quickSort(A, 0, A.length - 1);
		for (int i = 0; i < A.length; i++) {
			System.out.print(A[i] + " ");
		}
		System.out.println();
		System.out.println(mode(A));
	}

	public static int mode(int A[]) {

		int mode = 0;
		int run = 0;
		int maxRunTillNow = 0;

		for (int i = 1; i < A.length; i++) {
			run = 0;
			while (i < A.length && A[i] == A[i - 1]) {
				i++;
				run++;
			}
			if (run > maxRunTillNow) {
				maxRunTillNow = run;
				mode = A[i - 1];
			}
		}

		return mode;
	}

	public static void quickSort(int A[], int lo, int hi) {

		if (lo < hi) {
			// int pos = lomuntoPartition(A, lo, hi);
			int pos = hoarePartition(A, lo, hi);
			quickSort(A, lo, pos - 1);
			quickSort(A, pos + 1, hi);
		}
	}

	public static int lomuntoPartition(int A[], int lo, int hi) {

		int pivot = A[lo];
		int s = lo;

		for (int i = lo + 1; i <= hi; i++) {
			if (A[i] <= pivot) {
				s++;
				swap(A, s, i);
			}
		}
		swap(A, lo, s);
		return s;
	}

	public static int hoarePartition(int A[], int lo, int hi) {

		int pivot = A[lo];
		int i = lo;
		int j = hi;

		while (i < j) {
			while (i < hi && A[i] <= pivot) {
				i++;
			}
			while (j > lo && A[j] > pivot) {
				j--;
			}
			swap(A, i, j);
		}
		swap(A, i, j);
		swap(A, lo, j);
		return j;

	}

	public static void swap(int[] A, int i, int j) {
		int temp = A[i];
		A[i] = A[j];
		A[j] = temp;
	}
}
