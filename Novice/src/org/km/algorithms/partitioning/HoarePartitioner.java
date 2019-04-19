package org.km.algorithms.partitioning;

public class HoarePartitioner {

	private static int count = 0;

	public static void main(String[] args) {

		int A[] = { 6, 4, 3, 8, 0, 9, 5, -6, 7, 0, 2, 
				-63, 12, 8, 100, 9, 13, 0, 9, 3, 81, 24 , 32, 12, 4, 56, 45, 8, 43, 90, 123, 56};

		quickSort(A, 0, A.length - 1);
		for (int entry : A) {
			System.out.print(entry + " ");
		}
		System.out.println();
		System.out.println("\nBO--- " + count);
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
				count++;
			}
			while (j >= lo && A[j] > p) {
				j--;
				count++;
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
