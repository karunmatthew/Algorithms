package org.km.algorithms.partitioning;

public class HoarePartitioner {

	public static void main(String[] args) {

		int A[] = { 2, 7, 2, 2, 2, 2, 2, 2, 2 };

		quickSort(A, 0, A.length - 1);
		for (int entry : A) {
			System.out.print(entry + " ");
		}
		System.out.println();
	}

	private static void quickSort(int[] A, int lo, int hi) {
		if (lo < hi) {
			int pos = partition(A, lo, hi);
			quickSort(A, lo, pos - 1);
			quickSort(A, pos + 1, hi);
		}
	}

	private static int partition(int[] A, int lo, int hi) {
		int p = A[lo];
		int i = lo;
		int j = hi;
		while (i < j) {
			while (i < hi && A[i] <= p) {
				i++;
			}
			while (j >= lo && A[j] > p) {
				j--;
			}
			swap(i, j, A);
		}
		swap(i, j, A);
		swap(lo, j, A);
		return j;
	}

	private static void swap(int i, int j, int[] A) {
		int temp = A[i];
		A[i] = A[j];
		A[j] = temp;
	}
}
