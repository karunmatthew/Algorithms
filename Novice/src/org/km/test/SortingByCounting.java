package org.km.test;

public class SortingByCounting {
	public static void main(String[] args) {

		//int A[] = new int[] { 5, 8, 0, 1, 8, 1, 12, 13, 3, 2, 8 };
		int A[] = new int[] { 8, 8, 0, 2 };

		sort(A);
	}

	public static void sort(int[] A) {

		int count[] = new int[A.length];

		for (int i = 0; i < A.length; i++) {
			count[i] = 0;
		}

		for (int i = 0; i < A.length - 1; i++) {
			for (int j = i + 1; j < A.length; j++) {
				if (A[i] > A[j]) {
					count[i] = count[i] + 1;
				} else {
					count[j] = count[j] + 1;
				}
			}
		}

		int sortedArray[] = new int[A.length];

		for (int i = 0; i < A.length; i++) {
			sortedArray[count[i]] = A[i];
		}

		for (int i = 0; i < A.length; i++) {
			System.out.print(A[i] + "\t");
		}
		System.out.println();
		
		for (int i = 0; i < count.length; i++) {
			System.out.print(count[i] + "\t");
		}
		
		System.out.println();
		for (int i = 0; i < sortedArray.length; i++) {
			System.out.print(sortedArray[i] + "\t");
		}
	}
}
