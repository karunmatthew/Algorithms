package org.km.algorithms.heap;

public class Heap {

	public static void main(String[] args) {

		int A[] = { 0, 2, 9, 7, 6, 5, 8 };
		// int A[] = { 1, 15, 7, 12, 6, 0, 15, 7, 17, 15, 17, -2, -1, 23, 18 };

		int B[] = new int[100];

		int size = 0;
		for (int i = 1; i < A.length; i++) {
			topDownInsert(B, size, A[i]);
			size++;
		}
		for (int i = 0; i <= size; i++) {
			System.out.print(B[i] + " ");
		}

		for (int i = size; i >= 1; i--) {
			System.out.println("Deleting " + B[1]);
			deleteElement(B, i);
		}

		System.out.println();
		for (int i = size; i >= 1; i--) {

			System.out.print(B[i] + " ");
		}

		/*
		 * A = bottomUpHeap(A); for (int i : A) { System.out.print(i + " "); }
		 */
	}

	public static int[] bottomUpHeap(int[] H) {

		boolean isHeap = false;
		int childIndex = 0;
		int k;
		int value;
		int n = H.length - 1;

		for (int i = n / 2; i >= 1; i--) {

			isHeap = false;
			k = i;
			value = H[k];

			while (!isHeap && 2 * k <= n) {

				childIndex = 2 * k;
				if (childIndex < n) {
					if (H[childIndex] < H[childIndex + 1]) {
						childIndex = childIndex + 1;
					}
				}

				if (value >= H[childIndex]) {
					isHeap = true;
				} else {
					H[k] = H[childIndex];
					k = childIndex;
				}
			}
			H[k] = value;
		}

		return H;
	}

	public static void topDownInsert(int[] A, int size, int newElement) {

		// we assume that data is filled from A[1] to A[size]
		size++;
		A[size] = newElement;

		int parentIndex = size / 2;
		int currentIndex = size;

		while (parentIndex >= 1 && A[currentIndex] > A[parentIndex]) {
			swap(A, currentIndex, parentIndex);
			currentIndex = parentIndex;
			parentIndex = parentIndex / 2;
		}

	}

	public static void deleteElement(int[] A, int size) {
		System.out.println("Size ---- " + size);
		int deletedElement = A[1];
		A[1] = A[size];
		A[size] = deletedElement;
		size = size - 1;

		int currentIndex = 1;
		int childIndex = 2 * currentIndex;

		while ((childIndex <= size && A[currentIndex] < A[childIndex])
				|| (childIndex + 1 <= size && A[currentIndex] < A[childIndex + 1])) {
			if (childIndex + 1 <= size) {
				if (A[childIndex] < A[childIndex + 1]) {
					childIndex = childIndex + 1;
				}
			}

			swap(A, currentIndex, childIndex);
			currentIndex = childIndex;
			childIndex = 2 * childIndex;
		}

	}

	public static void swap(int[] A, int a, int b) {
		int temp = A[a];
		A[a] = A[b];
		A[b] = temp;
	}
}
