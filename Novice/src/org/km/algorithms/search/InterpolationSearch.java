package org.km.algorithms.search;

public class InterpolationSearch {

	public static void main(String[] args) {

		int A[] = new int[] { 5, 7, 8, 12, 16, 20, 24, 25, 27, 32, 36, 45, 46, 47, 48, 53, 57, 58, 62, 64, 69 };

		int position = search(A, 0, A.length - 1, 48);
		if (position == -1) {
			System.out.println("Not Found");
		} else {
			System.out.println("Found at " + position);
		}
	}

	public static int search(int[] A, double low, double high, double k) {

		if (low > high) {
			return -1;
		}

		int mid = (int) (low + ((k - A[(int) low]) / (A[(int) high] - A[(int) low])) * (high - low));

		/*
		 * Because mid is extrapolated there are chances that mid values falls out of
		 * range(low, high)
		 */

		if (mid < low || mid > high) {
			return -1;
		}

		if (A[mid] == k) {
			return mid;
		} else if (A[mid] <= k) {
			return search(A, mid + 1, high, k);
		} else {
			return search(A, low, mid - 1, k);
		}

	}
}
