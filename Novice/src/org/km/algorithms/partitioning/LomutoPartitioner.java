package org.km.algorithms.partitioning;

public class LomutoPartitioner {

	public static void main(String[] args) {

		int A[] = { 4, 0, 3, 2, 7 };

		System.out.println(quickSelect(A, 0, A.length - 1, 4));
		// quickSort(A, 0, A.length - 1);
		for (int entry : A) {
			System.out.print(entry + " ");
		}
	}

	public static void quickSort(int A[], int lo, int hi) {

		if (lo < hi) {
			int pivotPos = partition(A, lo, hi);
			quickSort(A, 0, pivotPos - 1);
			quickSort(A, pivotPos + 1, hi);
		}
	}

	// kth smallest
	public static int quickSelect(int[] A, int lo, int hi, int k) {

		int pos = partition(A, lo, hi);
		if (pos - lo + 1 == k) {
			return A[pos];
		} else if (pos - lo + 1 <= k) {
			return quickSelect(A, pos + 1, hi, k - (pos - lo + 1));
		} else {
			return quickSelect(A, lo, pos - 1, k);
		}

	}

	public static int partition(int A[], int lo, int hi) {

		int pivot = A[lo];
		int s = lo;

		for (int i = lo + 1; i <= hi; i++) {
			if (A[i] < pivot) {
				s++;
				swap(s, i, A);
			}
		}
		swap(lo, s, A);
		return s;
	}

	private static void swap(int i, int j, int[] A) {
		int temp = A[i];
		A[i] = A[j];
		A[j] = temp;
	}
}
