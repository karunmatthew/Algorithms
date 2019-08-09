package org.km.algorithms.sort;

public class HeapSort {

	public static void main(String[] args) {

		 int A[] = { 1, 15, 7, 12, 6, 0, 15, 7, 17, 15, 17, -2, -1, 23, 18 };
		//int A[] = { 2, 5, 7, 8, 6 };

		heapSort(A);
		for (int a : A)
			System.out.print(a + " ");
	}

	public static void heapSort(int A[]) {
		int n = A.length;
		// for (int i = 0; i < n; i++) insertIntoHeap(A, i);
		heapify(A);

		for (int i = n - 1; i >= 0; i--) {
			removeFromHeap(A, i);
		}
	}

	// O(n)
	public static void heapify(int A[]) {

		int start = (A.length - 2) / 2;
		int child_index;
		int current_index;
		int i = start;
		for (i = start; i >= 0; i--) {

			child_index = 2 * i + 1;
			current_index = i;
			while (child_index < A.length && (A[current_index] < A[child_index]
					|| ((child_index + 1 < A.length) && A[current_index] < A[child_index + 1]))) {

				child_index = findMaxChildIndex(A, child_index);
				swap(A, current_index, child_index);
				current_index = child_index;
				child_index = 2 * child_index + 1;
			}
		}
	}

	public static void removeFromHeap(int A[], int size) {

		int removed_item = A[0];
		A[0] = A[size];
		int current_index = 0;
		int child_index = 1;
		int temp = 0;
		size = size - 1;

		while (child_index <= size && (A[current_index] < A[child_index] || A[current_index] < A[child_index + 1])) {
			child_index = findMaxChildIndex(A, child_index);
			swap(A, current_index, child_index);
			temp = child_index;
			child_index = 2 * child_index + 1;
			current_index = temp;
		}
		A[size + 1] = removed_item;
	}

	public static int findMaxChildIndex(int[] A, int index) {

		if (index + 1 >= A.length || A[index] >= A[index + 1]) {
			return index;
		} else {
			return index + 1;
		}
	}

	// O(nlog n)
	public static void insertIntoHeap(int A[], int index) {
		int temp = 0;
		if (index == 0) {
			return;
		} else {
			int parent_index = (index - 1) / 2;
			while (parent_index >= 0 && A[parent_index] < A[index]) {
				swap(A, index, parent_index);
				temp = parent_index;
				parent_index = (parent_index - 1) / 2;
				index = temp;
			}
		}
	}

	public static void swap(int[] A, int i, int j) {
		int temp = A[i];
		A[i] = A[j];
		A[j] = temp;
	}

}
