package org.km.algorithms.sort;

public class QuickSelect {

	public static void main(String[] args) {

		// find the k largest element

		int A[] = { 72, 29, 64, 86, 33, 89, 38, 32, 94, 42 };

		System.out.println(kthSmallest(A, 4, 0, A.length - 1));

		print(A);

	}

	public static int kthSmallest(int A[], int k, int low, int high) {
		int s = partition(A, low, high);
		if (s - low == k - 1) {
			return A[s];
		} else if (s - low > k - 1) {
			return kthSmallest(A, k, low, s - 1);
		} else {
			return kthSmallest(A, (k - 1) - (s - low), s + 1, high);
		}
	}

	public static int partition(int A[], int low, int high) {

		int s = low;
		int pivot = A[low];
		int temp;

		for (int i = low + 1; i <= high; i++) {
			if (A[i] < pivot) {
				s++;
				System.out.println("Swapping " + A[i] + " and " + A[s]);
				temp = A[i];
				A[i] = A[s];
				A[s] = temp;
			}
		}

		A[low] = A[s];
		A[s] = pivot;
		return s;
	}

	public static void print(int[] A) {

		for (int i = 0; i < A.length; i++) {
			System.out.print(A[i] + " ");
		}
	}

}
