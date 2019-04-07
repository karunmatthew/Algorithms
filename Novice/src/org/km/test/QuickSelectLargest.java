package org.km.test;

import java.util.Arrays;

public class QuickSelectLargest {

	/*
	 * Code to find the nth smallest element in an array
	 */

	public static void main(String[] args) {
		int A[] = { 5, 2, 0, 1, 7, 3, 17, 22, 14, 1, 8, 9 };
		for (int i = 0; i < A.length; i++) {
			System.out.print(A[i] + " ");
		}

		int k = 5;
		System.out.println();
		putTheLastElementAtTheRightPlace(A, k);

		Arrays.sort(A);

		for (int i = 0; i < A.length; i++) {
			System.out.print(A[i] + " ");
		}

		System.out.println();
		for (int i = 0; i < A.length; i++) {
			System.out.print(i + 1 + " ");
		}

	}

	public static void putTheLastElementAtTheRightPlace(int[] A, int k) {
		System.out.println();
		for (int i = 0; i < A.length; i++) {
			System.out.print(A[i] + " ");
		}

		int n = A.length;
		int pivot = A[n - 1];

		int beg = 0;
		int end = n - 2;
		int temp;

		while (beg <= end) {

			if (A[beg] <= pivot) {
				beg++;
				continue;
			}

			if (A[end] > pivot) {
				end--;
				continue;
			}

			if (A[end] < A[beg]) {
				temp = A[end];
				A[end] = A[beg];
				A[beg] = temp;
				beg++;
				end--;
			}

		}
		// swap the last element to its rightful place

		temp = A[n - 1];
		A[n - 1] = A[beg];
		A[beg] = temp;

		System.out.println("\nbeg --- " + beg);
		for (int i = 0; i < A.length; i++) {
			System.out.print(A[i] + " ");
		}

		if (k == beg + 1) {
			System.out.println("Found largest ==> " + A[beg]);
		} else if (k > beg) {
			putTheLastElementAtTheRightPlace(partition(A, beg, A.length), k - beg);
		} else if (k <= beg) {
			putTheLastElementAtTheRightPlace(partition(A, 0, beg), k);
		}

	}

	public static int[] partition(int A[], int startIndex, int endIndex) {
		int B[] = new int[endIndex - startIndex];
		for (int i = startIndex; i < endIndex; i++) {
			B[i - startIndex] = A[i];

		}
		return B;
	}
}
