package org.km.algorithms.sort;

public class MergeSort {

	public static void main(String[] args) {

		int A[] = { 4, 6, 1, 0, 7, 3, -2, 5, 4, 0, 9, 0, 7 };
		int sortedArray[] = mergeSort(A);

		for (int a : sortedArray) {
			System.out.print(a + " ");
		}
	}

	public static int[] mergeSort(int A[]) {

		if (A.length == 1) {
			return A;
		} else {
			int B[] = copy(A, 0, (A.length - 1) / 2);
			int C[] = copy(A, (A.length - 1) / 2 + 1, A.length - 1);
			B = mergeSort(B);
			C = mergeSort(C);
			return merge(B, C, A);
		}

	}

	public static int[] merge(int[] B, int[] C, int[] A) {

		int a = 0;
		int b = 0;
		int c = 0;

		int m = B.length;
		int n = C.length;

		while (b < m && c < n) {

			if (B[b] <= C[c]) {
				A[a] = B[b];
				b++;
			} else {
				A[a] = C[c];
				c++;
			}
			a++;
		}

		if (b == m) {
			while (c < n) {
				A[a] = C[c];
				a++;
				c++;
			}
		}

		if (c == n) {
			while (b < m) {
				A[a] = B[b];
				a++;
				b++;
			}
		}

		return A;
	}

	public static int[] copy(int[] A, int start, int stop) {

		int B[] = new int[stop - start + 1];
		for (int i = start; i <= stop; i++) {
			B[i - start] = A[i];
		}
		return B;
	}
}
