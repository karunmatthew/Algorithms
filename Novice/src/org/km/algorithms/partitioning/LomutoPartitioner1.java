package org.km.algorithms.partitioning;

public class LomutoPartitioner1 {
	public static void main(String[] args) {

		int A[] = { 5, 1, 1, 1, 1, 1, 1 };

		int index = lomutoPartition(A);
		for (int entry : A) {

			System.out.print(entry + "  ");
		}
	}

	public static int lomutoPartition(int[] A) {

		int pivot = A[0];
		int s = 0;
		int n = A.length;
		for (int i = 1; i < n; i++) {

			if (A[i] < pivot) {
				s++;
				swap(A, s, i);
			}

		}
		swap(A, s, 0);

		return -1;
	}

	public static void swap(int[] A, int a, int b) {
		int temp = A[a];
		A[a] = A[b];
		A[b] = temp;
	}

}
